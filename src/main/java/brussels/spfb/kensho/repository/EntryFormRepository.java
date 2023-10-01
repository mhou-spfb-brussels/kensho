package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.EntryForm;

public interface EntryFormRepository extends JpaRepository<EntryForm, Long> {
}
