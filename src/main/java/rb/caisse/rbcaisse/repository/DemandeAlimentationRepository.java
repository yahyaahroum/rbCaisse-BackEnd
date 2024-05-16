package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.DemandeAlimentation;

public interface DemandeAlimentationRepository extends JpaRepository<DemandeAlimentation,Long > {
}
