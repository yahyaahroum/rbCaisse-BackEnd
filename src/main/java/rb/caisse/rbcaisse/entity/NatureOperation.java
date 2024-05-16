package rb.caisse.rbcaisse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "nature_op")
public class NatureOperation extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    @JsonIgnore
    @OneToMany(targetEntity = SuiviCaisse.class,mappedBy = "natureOperation")
    private List<SuiviCaisse> suiviCaisses;
    @ManyToOne
    @JoinColumn(name = "compte_comptable")
    private CompteComptable compteComptable;


}
