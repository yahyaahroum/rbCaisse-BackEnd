package rb.caisse.rbcaisse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "appartement",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "compteurEau"),
                @UniqueConstraint(columnNames = "compteurElectricite")
        })
public class Appartement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    private double montantLoye;
    private String compteurEau;
    private String compteurElectricite;
    @ManyToOne
    @JoinColumn(name = "id_affaire")
    private Affaire affaire;
/*    @JsonIgnore
    @OneToMany(targetEntity = Paiement_elec_eau.class,mappedBy = "appartement")
    private List<Paiement_elec_eau> paiement_elec_eauList;
    @JsonIgnore
    @OneToMany(targetEntity = PaiementLoye.class,mappedBy = "appartement")
    private List<PaiementLoye> paiementLoyeList;*/

}
