package rb.caisse.rbcaisse.service.Imp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.Affaire;
import rb.caisse.rbcaisse.entity.Caisse;
import rb.caisse.rbcaisse.entity.User;
import rb.caisse.rbcaisse.repository.AffaireRepository;
import rb.caisse.rbcaisse.repository.UserRepository;
import rb.caisse.rbcaisse.service.AffaireService;
import rb.caisse.rbcaisse.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AffaireServiceImp implements AffaireService {
    private AffaireRepository affaireRepository;
    private UserService userService;
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
        User user=userService.finduserById(id);
            String role = userService.roleUserConnected(user);
            if(role.equals("caissier")){

                return user.getAffaires();
            }else{
                return affaireRepository.findAll();
            }
        }

    }
