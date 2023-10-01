package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.FlowStep;

public interface FlowStepRepository extends JpaRepository<FlowStep, Long> {
}
