package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.Banque;

public interface BanqueRepository extends JpaRepository<Banque,Long > {
}
