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
@Table(name = "caisse")
public class Caisse extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double soldeActuel;
    @ManyToOne
    @JoinColumn(name = "id_affaire")
    private Affaire affaire;
    @JsonIgnore
    @OneToMany(targetEntity = SuiviCaisse.class,mappedBy = "caisse")
    private List<SuiviCaisse> suiviCaisses;
    @JsonIgnore
    @OneToMany(targetEntity = DemandeAlimentation.class,mappedBy = "caisse")
    private List<DemandeAlimentation> demandeAlimentations;
    @JsonIgnore
    @OneToMany(targetEntity = AlimentationCaisse.class,mappedBy = "caisse")
    private List<AlimentationCaisse> alimentationCaisseList;

}
