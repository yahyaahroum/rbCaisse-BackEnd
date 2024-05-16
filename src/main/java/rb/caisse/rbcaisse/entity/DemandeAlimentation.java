package rb.caisse.rbcaisse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "demande_alimentation")
public class DemandeAlimentation extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDemande;
    private String etat;
    private String motif;
    private String pieceJointe;
    @ManyToOne
    @JoinColumn(name = "id_caisse")
    private Caisse caisse;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
