package brussels.spfb.kensho.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import brussels.spfb.kensho.dto.DocumentDTO;
import de.qaware.tools.collectioncacheableforspring.CollectionCacheable;
import lombok.NonNull;

@Component
public class AlfrescoClient {

    @Cacheable(cacheNames = "documents", unless = "#result == null")
    public Optional<DocumentDTO> getDocumentById(@NonNull Long id) {
        return Optional.of(DocumentDTO.builder().id(id).build());
    }

    @Cacheable("documents")
    @CollectionCacheable("documents")
    public Map<Long, Optional<DocumentDTO>> getDocumentsByIds(@NonNull List<Long> ids) {
        HashMap<Long, Optional<DocumentDTO>> result = new HashMap<>();
        ids.stream().forEach(id -> result.put(id, Optional.of(DocumentDTO.builder().id(id).build())));
        return result;
    }

}
