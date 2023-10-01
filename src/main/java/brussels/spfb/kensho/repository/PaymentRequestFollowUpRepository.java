package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.PaymentRequestFollowUp;

public interface PaymentRequestFollowUpRepository extends JpaRepository<PaymentRequestFollowUp, Long> {
}
