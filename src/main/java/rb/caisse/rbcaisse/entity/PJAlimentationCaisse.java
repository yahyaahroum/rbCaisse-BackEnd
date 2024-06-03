package rb.caisse.rbcaisse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pj_alimentationcaisse")
public class PJAlimentationCaisse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date datePJ;
    private String fileName;
    @ManyToOne
    @JoinColumn(name = "id_alimentationcaisse")
    private AlimentationCaisse alimentationCaisse;
}
