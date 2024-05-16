package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.AlimentationCaisse;
import rb.caisse.rbcaisse.repository.AlimentationCaisseRepository;
import rb.caisse.rbcaisse.service.AlimentationCaisseService;

import java.util.List;

@Service
@AllArgsConstructor
public class AlimentationCaisseServiceImp implements AlimentationCaisseService {
    private AlimentationCaisseRepository alimentationCaisseRepository;
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
        alimentationCaisse.setId(id);
        return alimentationCaisseRepository.save(alimentationCaisse);
    }

    @Override
    public void deleteAlimentationCaisse(long id) {
        alimentationCaisseRepository.deleteById(id);
    }
}
