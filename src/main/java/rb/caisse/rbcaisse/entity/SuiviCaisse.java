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
@Table(name = "suivi_caisse")
public class SuiviCaisse extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateSuivi;
    private String designation;
    private String numeroPiece;
    private double montant;

    @ManyToOne
    @JoinColumn(name = "id_caisse")
    private Caisse caisse;
    @ManyToOne
    @JoinColumn(name = "id_nature")
    private NatureOperation natureOperation;
    @ManyToOne
    @JoinColumn(name = "id_mode")
    private ModeOperation modeOperation;
}
