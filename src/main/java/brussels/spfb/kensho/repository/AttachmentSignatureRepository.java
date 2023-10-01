package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.AttachmentSignature;

public interface AttachmentSignatureRepository extends JpaRepository<AttachmentSignature, Long> {
}
