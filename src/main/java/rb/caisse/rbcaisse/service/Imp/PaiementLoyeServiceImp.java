package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.PaiementLoye;
import rb.caisse.rbcaisse.repository.PaiementLoyeRepository;
import rb.caisse.rbcaisse.service.PaiementLoyeService;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementLoyeServiceImp implements PaiementLoyeService {
    private PaiementLoyeRepository paiementLoyeRepository;
    @Override
    public List<PaiementLoye> getAllPaiementLoye() {
        return paiementLoyeRepository.findAll();
    }

    @Override
    public PaiementLoye getPaiementLoyeById(long id) {
        return paiementLoyeRepository.findById(id).get();
    }

    @Override
    public PaiementLoye addPaiementLoye(PaiementLoye paiementLoye) {
        return paiementLoyeRepository.save(paiementLoye);
    }

    @Override
    public PaiementLoye updatePaiementLoye(PaiementLoye paiementLoye, long id) {
        paiementLoye.setId(id);
        return paiementLoyeRepository.save(paiementLoye);
    }

    @Override
    public void deletePaiementLoye(long id) {
        paiementLoyeRepository.deleteById(id);
    }
}
