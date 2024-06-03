package rb.caisse.rbcaisse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(	name = "affaire",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "code")
        })
public class Affaire implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;
    private String libelle;
    private String statut;
    @ManyToOne
    @JoinColumn(name = "id_caisse")
    private Caisse caisse;
/*   @JsonIgnore
   @OneToMany(targetEntity = Caisse.class,mappedBy = "affaire")
    private List<Caisse> caisseList;*/



}
