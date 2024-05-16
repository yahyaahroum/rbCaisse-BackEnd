package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.Appartement;
import rb.caisse.rbcaisse.repository.AppartementRepository;
import rb.caisse.rbcaisse.service.AppartementService;

import java.util.List;

@Service
@AllArgsConstructor
public class AppartementServiceImp implements AppartementService {
    private AppartementRepository appartementRepository;
    @Override
    public List<Appartement> getAllAppartement() {
        return appartementRepository.findAll();
    }

    @Override
    public Appartement getAppartementById(long id) {
        return appartementRepository.findById(id).get();
    }

    @Override
    public Appartement addAppartement(Appartement appartement) {
        return appartementRepository.save(appartement);
    }

    @Override
    public Appartement updateAppartement(Appartement appartement, long id) {
        appartement.setId(id);
        return appartementRepository.save(appartement);
    }

    @Override
    public void deleteAppartement(long id) {
        appartementRepository.deleteById(id);
    }
}
