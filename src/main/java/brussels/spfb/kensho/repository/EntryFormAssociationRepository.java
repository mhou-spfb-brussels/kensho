package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.EntryFormAssociation;

public interface EntryFormAssociationRepository extends JpaRepository<EntryFormAssociation, Long> {
}
