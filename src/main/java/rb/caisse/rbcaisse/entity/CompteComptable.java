package rb.caisse.rbcaisse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comptecomptable")
public class CompteComptable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codeComptable;
    private String intitule;
    @JsonIgnore
    @OneToMany(mappedBy = "compteComptable",targetEntity = CompteComptable.class)
    private List<NatureOperation> natureOperationListe;
}
