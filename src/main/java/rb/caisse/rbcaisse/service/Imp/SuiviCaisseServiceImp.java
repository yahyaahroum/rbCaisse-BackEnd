package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.SuiviCaisse;
import rb.caisse.rbcaisse.repository.SuiviCaisseRepository;
import rb.caisse.rbcaisse.service.SuiviCaisseService;

import java.util.List;

@Service
@AllArgsConstructor
public class SuiviCaisseServiceImp implements SuiviCaisseService {
    private SuiviCaisseRepository suiviCaisseRepository;
    @Override
    public List<SuiviCaisse> getAllSuiviCaisse() {
        return suiviCaisseRepository.findAll();
    }

    @Override
    public SuiviCaisse getSuiviCaisseById(long id) {
        return suiviCaisseRepository.findById(id).get();
    }

    @Override
    public SuiviCaisse addSuiviCaisse(SuiviCaisse suiviCaisse) {
        return suiviCaisseRepository.save(suiviCaisse);
    }

    @Override
    public SuiviCaisse updateSuiviCaisse(SuiviCaisse suiviCaisse, long id) {
        suiviCaisse.setId(id);
        return suiviCaisseRepository.save(suiviCaisse);
    }

    @Override
    public void deleteSuiviCaisse(long id) {
        suiviCaisseRepository.deleteById(id);
    }
}
