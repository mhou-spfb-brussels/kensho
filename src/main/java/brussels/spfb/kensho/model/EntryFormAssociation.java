package brussels.spfb.kensho.model;

import java.math.BigDecimal;

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
public class EntryFormAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    protected EntryForm entryForm;

    @Column(nullable = false)
    protected Long association;

    @Column(nullable = false)
    protected BigDecimal amount;

}
