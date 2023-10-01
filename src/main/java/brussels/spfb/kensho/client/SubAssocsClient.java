package brussels.spfb.kensho.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import brussels.spfb.kensho.dto.AssociationDTO;
import de.qaware.tools.collectioncacheableforspring.CollectionCacheable;
import lombok.NonNull;

@Component
public class SubAssocsClient {

    @Cacheable(cacheNames = "associations", unless = "#result == null")
    public Optional<AssociationDTO> getAssociationById(@NonNull Long id) {
        return Optional.of(AssociationDTO.builder().id(id).build());
    }

    @Cacheable("associations")
    @CollectionCacheable("associations")
    public Map<Long, Optional<AssociationDTO>> getAssociationsByIds(@NonNull List<Long> ids) {
        HashMap<Long, Optional<AssociationDTO>> result = new HashMap<>();
        ids.stream().forEach(id -> result.put(id, Optional.of(AssociationDTO.builder().id(id).build())));
        return result;
    }

}
