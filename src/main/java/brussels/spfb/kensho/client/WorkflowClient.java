package brussels.spfb.kensho.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import brussels.spfb.kensho.dto.FolderDTO;
import brussels.spfb.kensho.dto.FolderGroupDTO;
import de.qaware.tools.collectioncacheableforspring.CollectionCacheable;
import lombok.NonNull;

@Component
public class WorkflowClient {

    @Cacheable(cacheNames = "folders", unless = "#result == null")
    public Optional<FolderDTO> getFolderById(@NonNull Long id) {
        return Optional.of(FolderDTO.builder().id(id).build());
    }

    @Cacheable("folders")
    @CollectionCacheable("folders")
    public Map<Long, Optional<FolderDTO>> getFoldersByIds(@NonNull List<Long> ids) {
        HashMap<Long, Optional<FolderDTO>> result = new HashMap<>();
        ids.stream().forEach(id -> result.put(id, Optional.of(FolderDTO.builder().id(id).build())));
        return result;
    }

    @Cacheable(cacheNames = "folderGroups", unless = "#result == null")
    public Optional<FolderGroupDTO> getFolderGroupById(@NonNull Long id) {
        return Optional.of(FolderGroupDTO.builder().id(id).build());
    }

    @Cacheable("folderGroups")
    @CollectionCacheable("folderGroups")
    public Map<Long, Optional<FolderGroupDTO>> getFolderGroupsByIds(@NonNull List<Long> ids) {
        HashMap<Long, Optional<FolderGroupDTO>> result = new HashMap<>();
        ids.stream().forEach(id -> result.put(id, Optional.of(FolderGroupDTO.builder().id(id).build())));
        return result;
    }

}
