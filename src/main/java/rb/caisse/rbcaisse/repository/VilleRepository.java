package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.Ville;

public interface VilleRepository extends JpaRepository<Ville,Long> {
}