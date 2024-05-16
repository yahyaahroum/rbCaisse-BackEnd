package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.Banque;
import rb.caisse.rbcaisse.repository.BanqueRepository;
import rb.caisse.rbcaisse.service.BanqueService;

import java.util.List;

@Service
@AllArgsConstructor
public class BanqueServiceImp implements BanqueService {
    private BanqueRepository banqueRepository;
    @Override
    public List<Banque> getAllBanque() {
        return banqueRepository.findAll();
    }

    @Override
    public Banque getBanqueById(long id) {
        return banqueRepository.findById(id).get();
    }

    @Override
    public Banque addBanque(Banque banque) {
        return banqueRepository.save(banque);
    }

    @Override
    public Banque updateBanque(Banque banque, long id) {
        banque.setId(id);
        return banqueRepository.save(banque);
    }

    @Override
    public void deleteBanque(long id) {
        banqueRepository.deleteById(id);
    }
}
