package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
