package brussels.spfb.kensho.model;

import org.hibernate.envers.Audited;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Audited(withModifiedFlag = true)
public class PaymentRequestFollowUp extends FollowUp {

    @Column(nullable = false)
    protected Long paymentRequest;

}
