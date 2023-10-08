package brussels.spfb.kensho.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import brussels.spfb.kensho.dto.UserDTO;
import brussels.spfb.kensho.dto.UserRoleDTO;
import de.qaware.tools.collectioncacheableforspring.CollectionCacheable;
import lombok.NonNull;

@Component
public class TrombiClient {

    // FIXME Stub
    protected static List<UserDTO> fakeUsers =
            List.of(UserDTO.builder().id(1L).userName("admin").password("admin").build(),
                    UserDTO.builder().id(2L).userName("user").password("user").build(),
                    UserDTO.builder().id(3L).userName("guest").password("guest").build());
    protected static List<UserRoleDTO> fakeUserRoles =
            List.of(UserRoleDTO.builder().id(1L).user(fakeUsers.get(0)).role(1L).build(),
                    UserRoleDTO.builder().id(2L).user(fakeUsers.get(1)).role(2L).build());

    // FIXME Stub
    @Cacheable(cacheNames = "users", unless = "#result == null")
    public Optional<UserDTO> getUserById(@NonNull Long id) {
        return fakeUsers.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    // FIXME Stub
    @Cacheable("users")
    @CollectionCacheable("users")
    public Map<Long, Optional<UserDTO>> getUsersByIds(@NonNull List<Long> ids) {
        HashMap<Long, Optional<UserDTO>> result = new HashMap<>();
        ids.stream().forEach(id -> result.put(id, getUserById(id)));
        return result;
    }

    // FIXME Stub
    @Cacheable(cacheNames = "users", unless = "#result == null")
    public Optional<UserDTO> getUserByUserName(@NonNull String userName, boolean partial) {
        return fakeUsers.stream()
                .filter(user -> partial
                        ? StringUtils.containsIgnoreCase(user.getUserName(), userName)
                        : StringUtils.equalsIgnoreCase(user.getUserName(), userName))
                .findFirst();
    }

    // FIXME Stub
    @Cacheable("users")
    @CollectionCacheable("users")
    public Map<Long, Optional<UserDTO>> getUsersByUserNames(@NonNull List<String> userNames,
            boolean partial) {
        HashMap<Long, Optional<UserDTO>> result = new HashMap<>();
        userNames.stream().forEach(userName -> {
            Optional<UserDTO> user = getUserByUserName(userName, partial);
            if (user.isPresent()) {
                result.put(user.get().getId(), user);
            }
        });
        return result;
    }

    public Map<String, Optional<UserDTO>> getUsersForUserNames(@NonNull List<String> userNames,
            boolean partial) {
        Map<Long, Optional<UserDTO>> users = getUsersByUserNames(userNames, partial);
        Map<String, Optional<UserDTO>> result = new HashMap<>();
        userNames.stream()
                .forEach(userName -> result.put(userName, users.values().stream().map(Optional::get)
                        .filter(user -> user.getUserName().equals(userName)).findFirst()));
        return result;
    }

    // FIXME Stub
    @Cacheable("userRoles")
    @CollectionCacheable("userRoles")
    public List<UserRoleDTO> getUserRolesByUser(@NonNull UserDTO user) {
        return fakeUserRoles.stream().filter(userRole -> userRole.getUser().equals(user))
                .collect(Collectors.toList());
    }

}
