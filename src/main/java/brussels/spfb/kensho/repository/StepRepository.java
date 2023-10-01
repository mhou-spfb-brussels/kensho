package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.Step;

public interface StepRepository extends JpaRepository<Step, Long> {
}
