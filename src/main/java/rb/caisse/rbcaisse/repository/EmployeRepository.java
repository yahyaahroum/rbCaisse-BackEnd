package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Long > {
}
