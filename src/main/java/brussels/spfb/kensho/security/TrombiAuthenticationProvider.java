package brussels.spfb.kensho.security;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import brussels.spfb.kensho.client.TrombiClient;
import brussels.spfb.kensho.dto.UserDTO;

@Component
public class TrombiAuthenticationProvider implements AuthenticationProvider {

    protected TrombiClient trombiClient;

    public TrombiAuthenticationProvider(TrombiClient trombiClient) {
        this.trombiClient = trombiClient;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDTO user = trombiClient.getUserByUserName(userName, false).orElse(null);
        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException(userName);
        }
        if (user.getPassword().equals(password)) {
            return new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword(),
                    trombiClient.getUserRolesByUser(user).stream().map(
                            userRole -> new SimpleGrantedAuthority(userRole.getRole().toString()))
                            .toList());
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
