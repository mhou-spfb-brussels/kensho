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
public class DecreeFollowUp extends FollowUp {

    @Column(nullable = false)
    protected Integer year;

    @Column(nullable = false)
    protected Integer number;

    @Column(nullable = false)
    protected Integer qualifier;

    protected Long workflowFolder;

    protected Long workflowFolderGroup;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    protected DecreeFollowUpType decreeFollowUpType;

    protected Long minister;

    @Column(nullable = false)
    protected Boolean signatureDelegation;

    @ManyToOne
    protected FinancialInspectionFollowUp financialInspectionFollowUp;

    protected Integer collegeAgenda;

}
