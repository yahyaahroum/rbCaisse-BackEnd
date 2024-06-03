package rb.caisse.rbcaisse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alimentation_caisse")
public class AlimentationCaisse extends Auditable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateDemande;
    private String statut;
    private String motif;
    private double montant;
/*    @JsonIgnore
    @OneToMany(targetEntity = PJAlimentationCaisse.class,mappedBy = "alimentationCaisse")
    private List<PJAlimentationCaisse> listepjAlimentationCaisse;*/
    @ManyToOne
    @JoinColumn(name = "id_caisse")
    private Caisse caisse;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User demandePar;
   @ManyToOne
    @JoinColumn(name = "id_nature")
    private NatureAlimentation natureAlimentation;

}
