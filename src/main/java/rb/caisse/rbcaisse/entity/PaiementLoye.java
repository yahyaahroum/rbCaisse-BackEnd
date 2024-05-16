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
@Table(name = "paiement_loye")
public class PaiementLoye extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int moisLoye;
    private int anneeLoye;
    @ManyToOne
    @JoinColumn(name = "id_appartement")
    private Appartement appartement;
    @ManyToMany
    @JoinTable(name = "employe_loye",
    joinColumns = @JoinColumn(name = "loye_id"),
    inverseJoinColumns = @JoinColumn(name = "id_employe"))
    private List<Employe> employeList;

}
