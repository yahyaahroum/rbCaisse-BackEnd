package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.NatureAlimentation;

public interface NatureAlimentationRepository extends JpaRepository<NatureAlimentation,Long> {
Boolean existsByLibelle(String libelle);
}
