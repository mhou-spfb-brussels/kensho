package brussels.spfb.kensho.model;

import java.math.BigDecimal;
import org.hibernate.envers.Audited;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Audited(withModifiedFlag = true)
public class PurchaseOrder extends FollowUp {

    @Column(nullable = false)
    protected Integer year;

    @Column(nullable = false)
    protected Integer number;

    @Column(nullable = false)
    protected String provider;

    @Column(nullable = false)
    protected BigDecimal amount;

}
