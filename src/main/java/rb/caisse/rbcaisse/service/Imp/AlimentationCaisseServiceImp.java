package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.AlimentationCaisse;
import rb.caisse.rbcaisse.entity.PJAlimentationCaisse;
import rb.caisse.rbcaisse.repository.AlimentationCaisseRepository;
import rb.caisse.rbcaisse.repository.PJAlimentationCaisseRepository;
import rb.caisse.rbcaisse.service.AlimentationCaisseService;
import rb.caisse.rbcaisse.service.FilesStorageService;

import java.util.List;

@Service
@AllArgsConstructor
public class AlimentationCaisseServiceImp implements AlimentationCaisseService {
    private AlimentationCaisseRepository alimentationCaisseRepository;
    private FilesStorageService filesStorageService;
    private PJAlimentationCaisseRepository pjAlimentationCaisseRepository;
    @Override
    public List<AlimentationCaisse> getAllAlimentationCaisse() {
        return alimentationCaisseRepository.findAll();
    }

    @Override
    public AlimentationCaisse getAlimentationCaisseById(long id) {
        return alimentationCaisseRepository.findById(id).get();
    }

    @Override
    public AlimentationCaisse addAlimentationCaisse(AlimentationCaisse alimentationCaisse) {
        return alimentationCaisseRepository.save(alimentationCaisse);
    }

    @Override
    public AlimentationCaisse updateAlimentationCaisse(AlimentationCaisse alimentationCaisse, long id) {
        AlimentationCaisse da=getAlimentationCaisseById(id);
        da.setMontant(alimentationCaisse.getMontant());
        da.setCaisse(alimentationCaisse.getCaisse());
        da.setMotif(alimentationCaisse.getMotif());
        da.setNatureAlimentation(alimentationCaisse.getNatureAlimentation());
        //demandeAlimentation.setId(id);
        return alimentationCaisseRepository.save(da);
    }

    @Override
    public void deleteAlimentationCaisse(long id) {
        List<PJAlimentationCaisse> pjs=pjAlimentationCaisseRepository.findAllByAlimentationCaisse_Id(id);
        pjs.forEach(a->{
            filesStorageService.delete(a.getFileName());
                });
        alimentationCaisseRepository.deleteById(id);
    }

    @Override
    public void statutAlimentationCaisse(long id,String statut) {
        AlimentationCaisse alimentation=alimentationCaisseRepository.findById(id).get();
        alimentation.setId(id);
        alimentation.setStatut(statut);
        alimentationCaisseRepository.save(alimentation);
    }

}
