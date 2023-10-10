package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.FinancialInspectionFollowUpReview;

public interface FinancialInspectionFollowUpReviewRepository
                extends JpaRepository<FinancialInspectionFollowUpReview, Long> {
}
