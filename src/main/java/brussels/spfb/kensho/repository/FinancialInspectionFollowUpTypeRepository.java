package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.FinancialInspectionFollowUpType;

public interface FinancialInspectionFollowUpTypeRepository
        extends JpaRepository<FinancialInspectionFollowUpType, Long> {
}
