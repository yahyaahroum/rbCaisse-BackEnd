package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.Caisse;

public interface CaisseRepository extends JpaRepository<Caisse,Long> {
    Caisse findCaisseByAffaire_Code(String code);
}
