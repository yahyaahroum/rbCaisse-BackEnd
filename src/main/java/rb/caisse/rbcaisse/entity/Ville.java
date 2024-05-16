package rb.caisse.rbcaisse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(	name = "ville",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "libelle")
        })
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    @JsonIgnore
    @OneToMany(targetEntity = Appartement.class,mappedBy = "ville")
    private List<Appartement> AppartementList;
}
