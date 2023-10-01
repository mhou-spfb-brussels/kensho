package brussels.spfb.kensho.model;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Audited(withModifiedFlag = true)
public class AttachmentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected Boolean mandatory;

    @Column(nullable = false)
    protected Boolean unique;

    @Column(nullable = false)
    protected Boolean printable;

}
