package rb.caisse.rbcaisse.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Auditable {

    @CreatedBy
    @Column(name = "Creer_par")
    private String createdBy;

    @CreatedDate
    @Column(name = "Creer_le")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "Modifier_par")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "Modifier_le")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

}
