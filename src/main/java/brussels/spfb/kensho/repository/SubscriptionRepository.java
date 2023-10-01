package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
