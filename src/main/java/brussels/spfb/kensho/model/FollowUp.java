package brussels.spfb.kensho.model;

import org.hibernate.envers.Audited;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Audited(withModifiedFlag = true)
public abstract class FollowUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    protected Flow flow;

    @ManyToOne
    @JoinColumn(nullable = true)
    protected FollowUp parent;

    @Column(nullable = false)
    protected String description;

    @Column(nullable = false)
    protected Boolean urgent;

    protected String comment;

}
