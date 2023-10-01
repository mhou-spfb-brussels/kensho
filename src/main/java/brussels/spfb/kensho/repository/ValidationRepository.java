package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.Validation;

public interface ValidationRepository extends JpaRepository<Validation, Long> {
}
