package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.ModeOperation;

public interface ModeOperationRepository extends JpaRepository<ModeOperation,Long > {
    Boolean existsByLibelle(String libelle);
}
