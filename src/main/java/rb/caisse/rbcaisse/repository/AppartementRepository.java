package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.Appartement;

public interface AppartementRepository extends JpaRepository<Appartement,Long > {
}
