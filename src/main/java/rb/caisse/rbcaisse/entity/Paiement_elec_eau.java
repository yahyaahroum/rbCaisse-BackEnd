package rb.caisse.rbcaisse.entity;

import jakarta.persistence.*;
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
@Table(name = "paiement_elec_eau")
public class Paiement_elec_eau extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private double montant;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePaiement;
    private int moisFacture;
    private int anneeFacture;
    @ManyToOne
    @JoinColumn(name = "id_appartement")
    private Appartement appartement;
}
