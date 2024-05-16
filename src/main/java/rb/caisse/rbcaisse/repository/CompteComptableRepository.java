package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.CompteComptable;

public interface CompteComptableRepository extends JpaRepository<CompteComptable,Long> {
}
