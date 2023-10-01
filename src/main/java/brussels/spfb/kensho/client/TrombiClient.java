package brussels.spfb.kensho.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import brussels.spfb.kensho.dto.UserDTO;
import de.qaware.tools.collectioncacheableforspring.CollectionCacheable;
import lombok.NonNull;

@Component
public class TrombiClient {

    @Cacheable(cacheNames = "users", unless = "#result == null")
    public Optional<UserDTO> getUserById(@NonNull Long id) {
        return Optional.of(UserDTO.builder().id(id).build());
    }

    @Cacheable("users")
    @CollectionCacheable("users")
    public Map<Long, Optional<UserDTO>> getUsersByIds(@NonNull List<Long> ids) {
        HashMap<Long, Optional<UserDTO>> result = new HashMap<>();
        ids.stream().forEach(id -> result.put(id, Optional.of(UserDTO.builder().id(id).build())));
        return result;
    }

}
