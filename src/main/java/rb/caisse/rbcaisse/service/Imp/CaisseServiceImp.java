package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.Caisse;
import rb.caisse.rbcaisse.repository.CaisseRepository;
import rb.caisse.rbcaisse.service.CaisseService;

import java.util.List;

@Service
@AllArgsConstructor
public class CaisseServiceImp implements CaisseService {
    private CaisseRepository caisseRepository;
    @Override
    public List<Caisse> getAllCaisse() {
        return caisseRepository.findAll();
    }

    @Override
    public Caisse getCaisseById(long id) {
        return caisseRepository.findById(id).get();
    }

    @Override
    public Caisse addCaisse(Caisse caisse) {
        return caisseRepository.save(caisse);
    }

    @Override
    public Caisse updateCaisse(Caisse caisse, long id) {
        caisse.setId(id);
        return caisseRepository.save(caisse);
    }

    @Override
    public void deleteCaisse(long id) {
        caisseRepository.deleteById(id);
    }
}
