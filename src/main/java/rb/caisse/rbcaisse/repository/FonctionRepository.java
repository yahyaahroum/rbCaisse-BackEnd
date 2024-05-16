package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.Fonction;

public interface FonctionRepository extends JpaRepository<Fonction,Long > {
}
