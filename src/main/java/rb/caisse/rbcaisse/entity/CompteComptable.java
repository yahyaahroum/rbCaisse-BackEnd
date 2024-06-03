package rb.caisse.rbcaisse.entity;

import java.io.Serializable;

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
public class CompteComptable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codeComptable;
    private String intitule;

    public CompteComptable(String s, String s1) {
    }
}
 /*   @JsonIgnore
    @OneToMany(targetEntity = CompteComptable.class,mappedBy = "compteComptable")
    private List<NatureOperation> natureOperationListe;
}*/
