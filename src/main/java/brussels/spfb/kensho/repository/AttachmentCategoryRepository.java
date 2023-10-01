package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.AttachmentCategory;

public interface AttachmentCategoryRepository extends JpaRepository<AttachmentCategory, Long> {
}
