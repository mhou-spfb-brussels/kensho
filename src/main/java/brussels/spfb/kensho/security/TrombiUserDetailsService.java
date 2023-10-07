package brussels.spfb.kensho.security;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import brussels.spfb.kensho.client.TrombiClient;
import brussels.spfb.kensho.dto.UserDTO;

@Service
public class TrombiUserDetailsService implements UserDetailsService {
    @Autowired
    TrombiClient trombiClient;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDTO user = trombiClient.getUserByUserName(userName).orElse(null);
        if (user == null) {
            return null;
        }
        List<UserRoleDTO> roles = trombiClient.getUserRolesByUser(user);
        Set<GrantedAuthority> grantedAuthorities = roles.stream()
                .map((role) -> new SimpleGrantedAuthority(role.getId()))
                .collect(Collectors.toSet());
        return new User(username, user.getPassword(), grantedAuthorities);
    }

}
