package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.Fonction;
import rb.caisse.rbcaisse.repository.FonctionRepository;
import rb.caisse.rbcaisse.service.FonctionService;

import java.util.List;

@Service
@AllArgsConstructor
public class FonctionServiceImp implements FonctionService {
    private FonctionRepository fonctionRepository;
    @Override
    public List<Fonction> getAllFonction() {
        return fonctionRepository.findAll();
    }

    @Override
    public Fonction FonctionById(long id) {
        return fonctionRepository.findById(id).get();
    }

    @Override
    public Fonction addFonction(Fonction fonction) {
        return fonctionRepository.save(fonction);
    }

    @Override
    public Fonction updateFonction(Fonction fonction, long id) {
        fonction.setId(id);
        return fonctionRepository.save(fonction);
    }

    @Override
    public void deleteFonction(long id) {
        fonctionRepository.deleteById(id);
    }
}
