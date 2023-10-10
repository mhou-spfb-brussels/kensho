package brussels.spfb.kensho.model;

import java.util.Date;
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
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    protected FollowUp followUp;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    protected AttachmentCategory attachmentCategory;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected Long user;

    @Column(nullable = false)
    protected Date date;

    @Column(nullable = false)
    protected Long document;

    @Column(nullable = false)
    protected Boolean archived;

}
