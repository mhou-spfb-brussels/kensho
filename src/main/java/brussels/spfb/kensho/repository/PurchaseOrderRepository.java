package brussels.spfb.kensho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import brussels.spfb.kensho.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
