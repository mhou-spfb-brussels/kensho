package brussels.spfb.kensho.model;

import org.hibernate.envers.Audited;

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
public class StepAttachmentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    protected Step step;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    protected AttachmentCategory attachmentCategory;

}
