package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.DemandeAlimentation;
import rb.caisse.rbcaisse.repository.DemandeAlimentationRepository;
import rb.caisse.rbcaisse.service.DemandeAlimentationService;

import java.util.List;

@Service
@AllArgsConstructor
public class DemandeAlimentationServiceImp implements DemandeAlimentationService {
    private DemandeAlimentationRepository demandeAlimentationRepository;
    @Override
    public List<DemandeAlimentation> getAllDemandeAlimentation() {
        return demandeAlimentationRepository.findAll();
    }

    @Override
    public DemandeAlimentation getDemandeAlimentationById(long id) {
        return demandeAlimentationRepository.findById(id).get();
    }

    @Override
    public DemandeAlimentation addDemandeAlimentation(DemandeAlimentation demandeAlimentation) {
        return demandeAlimentationRepository.save(demandeAlimentation);
    }

    @Override
    public DemandeAlimentation updateDemandeAlimentation(DemandeAlimentation demandeAlimentation, long id) {
        demandeAlimentation.setId(id);
        return demandeAlimentationRepository.save(demandeAlimentation);
    }

    @Override
    public void deleteDemandeAlimentation(long id) {
        demandeAlimentationRepository.deleteById(id);
    }
}
