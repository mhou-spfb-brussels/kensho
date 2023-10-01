package brussels.spfb.kensho.model;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@Audited(withModifiedFlag = true)
public class FollowUpContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected Long user;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    protected FollowUp followUp;

    @Column(nullable = false)
    protected Boolean primary;

}
