package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.Affaire;
import rb.caisse.rbcaisse.entity.Appartement;

import java.util.List;

public interface AppartementRepository extends JpaRepository<Appartement,Long > {

    List<Appartement> findAllByAffaire(Affaire affaires);
}
