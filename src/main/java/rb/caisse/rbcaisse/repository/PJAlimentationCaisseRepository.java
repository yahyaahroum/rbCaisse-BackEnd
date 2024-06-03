package rb.caisse.rbcaisse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rb.caisse.rbcaisse.entity.PJAlimentationCaisse;

import java.util.List;

public interface PJAlimentationCaisseRepository extends JpaRepository<PJAlimentationCaisse,Long> {
    void deleteByFileName(String name);
    PJAlimentationCaisse findByFileName(String name);
    List<PJAlimentationCaisse> findAllByAlimentationCaisse_Id(long id);
}
