package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.Paiement_elec_eau;
import rb.caisse.rbcaisse.repository.Paiement_elec_eauRepository;
import rb.caisse.rbcaisse.service.Paiement_elec_eauService;

import java.util.List;

@Service
@AllArgsConstructor
public class Paiement_elec_eauServiceImp implements Paiement_elec_eauService {
    private Paiement_elec_eauRepository paiementElecEauRepository;
    @Override
    public List<Paiement_elec_eau> getAllPaiement_elec_eau() {
        return paiementElecEauRepository.findAll();
    }

    @Override
    public Paiement_elec_eau getPaiement_elec_eauById(long id) {
        return paiementElecEauRepository.findById(id).get();
    }

    @Override
    public Paiement_elec_eau addPaiement_elec_eau(Paiement_elec_eau paiementElecEau) {
        return paiementElecEauRepository.save(paiementElecEau);
    }

    @Override
    public Paiement_elec_eau updatePaiement_elec_eau(Paiement_elec_eau paiementElecEau, long id) {
        paiementElecEau.setId(id);
        return paiementElecEauRepository.save(paiementElecEau);
    }

    @Override
    public void deletePaiement_elec_eau(long id) {
        paiementElecEauRepository.deleteById(id);
    }
}
