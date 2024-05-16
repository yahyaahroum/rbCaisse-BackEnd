package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.Affaire;

public interface AffaireRepository extends JpaRepository<Affaire,Long> {
    Affaire findByCode(String codechantier);
}
