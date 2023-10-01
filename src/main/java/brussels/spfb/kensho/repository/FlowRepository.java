package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.Flow;

public interface FlowRepository extends JpaRepository<Flow, Long> {
}
