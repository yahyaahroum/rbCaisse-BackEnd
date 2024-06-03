package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.Caisse;
import rb.caisse.rbcaisse.entity.PJAlimentationCaisse;
import rb.caisse.rbcaisse.entity.SuiviCaisse;
import rb.caisse.rbcaisse.repository.CaisseRepository;
import rb.caisse.rbcaisse.repository.SuiviCaisseRepository;
import rb.caisse.rbcaisse.service.CaisseService;
import rb.caisse.rbcaisse.service.FilesStorageService;
import rb.caisse.rbcaisse.service.SuiviCaisseService;

import java.util.List;

@Service
@AllArgsConstructor
public class SuiviCaisseServiceImp implements SuiviCaisseService {
    private SuiviCaisseRepository suiviCaisseRepository;
    private CaisseService caisseService;
    private FilesStorageService filesStorageService;
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
        Caisse caisse=suiviCaisse.getCaisse();
       caisse.setSoldeActuel(caisse.getSoldeActuel()-suiviCaisse.getMontant());
       caisseService.updateCaisse(caisse,suiviCaisse.getCaisse().getId());
         return suiviCaisseRepository.save(suiviCaisse);
    }

    @Override
    public SuiviCaisse updateSuiviCaisse(SuiviCaisse suiviCaisse, long id) {
       SuiviCaisse oldSuivi=suiviCaisseRepository.findById(id).get();
        Caisse caisse=suiviCaisse.getCaisse();
        caisse.setSoldeActuel(oldSuivi.getCaisse().getSoldeActuel()+(oldSuivi.getMontant()-suiviCaisse.getMontant()));
        caisseService.updateCaisse(caisse,caisse.getId());
        suiviCaisse.setId(id);
        return suiviCaisseRepository.save(suiviCaisse);
    }

    @Override
    public void deleteSuiviCaisse(long id) {
        SuiviCaisse suivi=suiviCaisseRepository.findById(id).get();
        filesStorageService.deletePJSuiviCaisse(suivi.getPieceJointe());
        Caisse caisse=suivi.getCaisse();
        caisse.setSoldeActuel(caisse.getSoldeActuel()+suivi.getMontant());
        caisseService.updateCaisse(caisse,suivi.getCaisse().getId());
        suiviCaisseRepository.deleteById(id);
    }
}
