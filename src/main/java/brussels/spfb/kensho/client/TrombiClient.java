package brussels.spfb.kensho.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import brussels.spfb.kensho.dto.UserDTO;
import brussels.spfb.kensho.dto.UserRoleDTO;
import brussels.spfb.kensho.model.Role;
import de.qaware.tools.collectioncacheableforspring.CollectionCacheable;
import lombok.NonNull;

@Component
public class TrombiClient {

    // FIXME Stub
    protected static List<UserDTO> USERS = List.of(UserDTO.builder().id(1).userName("admin").password("admin").build(),
                                                   UserDTO.builder().id(2).userName("user").password("user").build(),
                                                   UserDTO.builder().id(3).userName("guest").password("guest").build());
    protected static List<UserRoleDTO> USER_ROLES = List.of(UserRoleDTO.builder().id(1).user(1).role(1).build(),
                                                           UserRoleDTO.builder().id(2).user(2).role(2).build());

    // FIXME Stub
    @Cacheable(cacheNames = "users", unless = "#result == null")
    public Optional<UserDTO> getUserById(@NonNull Long id) {
        return USERS.stream().filter(user -> user.getId().equals(id)).findFirst();
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
    public Optional<UserDTO> getUserByUserName(@NonNull String userName) {
        return USERS.stream().filter(user -> user.getUserName().equals(userName)).findFirst();
    }

    // FIXME Stub
    @Cacheable("users")
    @CollectionCacheable("users")
    public Map<Long, Optional<UserDTO>> getUsersByUserNames(@NonNull List<String> userNames) {
        HashMap<Long, Optional<UserDTO>> result = new HashMap<>();
        userNames.stream().forEach(userName -> {
            Optional<UserDTO> user = getUserByUserName(userName);
            if (user.isPresent()) {
                result.put(user.get().getId(), user);
            }
        });
        return result;
    }

    // FIXME Stub
    @Cacheable("userRoles")
    @CollectionCacheable("userRoles")
    public List<UserRoleDTO> getUserRolesByUser(@NonNull UserDTO user) {
        return USER_ROLES.stream().filter(userRole -> userRole.getUser().equals(user).collect(Collectors.toList());
    }

}
