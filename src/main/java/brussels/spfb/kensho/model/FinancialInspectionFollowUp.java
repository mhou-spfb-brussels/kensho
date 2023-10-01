package brussels.spfb.kensho.model;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Audited(withModifiedFlag = true)
public class FinancialInspectionFollowUp extends FollowUp {

    @Column(nullable = false)
    protected Long number;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    protected FinancialInspectionFollowUpType financialInspectionFollowUpType;

    @ManyToOne
    protected FinancialInspectionFollowUpReview financialInspectionFollowUpReview;

    protected String frenchCommunityFolder;

    protected String frenchCommunityDivision;

}
