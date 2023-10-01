package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.FollowUpContact;

public interface FollowUpContactRepository extends JpaRepository<FollowUpContact, Long> {
}
