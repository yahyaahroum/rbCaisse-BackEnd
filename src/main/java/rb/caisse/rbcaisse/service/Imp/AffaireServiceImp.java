package rb.caisse.rbcaisse.service.Imp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.Affaire;
import rb.caisse.rbcaisse.repository.AffaireRepository;
import rb.caisse.rbcaisse.service.AffaireService;

import java.util.List;

@Service
@AllArgsConstructor
public class AffaireServiceImp implements AffaireService {
    private AffaireRepository affaireRepository;
    @Override
    public List<Affaire> getAllAffaires() {
        return affaireRepository.findAll();
    }

    @Override
    public Affaire getAffaireById(long id) {
        return affaireRepository.findById(id).get();
    }

    @Override
    public Affaire addAffaire(Affaire affaire) {
        return affaireRepository.save(affaire);
    }

    @Override
    public Affaire updateAffaire(Affaire affaire, long id) {
        affaire.setId(id);
        return affaireRepository.save(affaire);
    }

    @Override
    public void deleteAffaire(long id) {
        affaireRepository.deleteById(id);
    }

    @Override
    public Affaire findAffaireByCode(String codeAffaire) {

        return affaireRepository.findByCode(codeAffaire);
    }

    @Override
    public List<Affaire> getAffairesByUser(long id) {
        return null;
    }
}
