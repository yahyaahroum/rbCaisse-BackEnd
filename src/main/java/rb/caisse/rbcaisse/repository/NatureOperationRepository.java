package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.NatureOperation;

public interface NatureOperationRepository extends JpaRepository<NatureOperation,Long > {
}
