package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.Affaire;
import rb.caisse.rbcaisse.entity.Caisse;
import rb.caisse.rbcaisse.entity.Role;
import rb.caisse.rbcaisse.entity.User;
import rb.caisse.rbcaisse.repository.CaisseRepository;
import rb.caisse.rbcaisse.repository.UserRepository;
import rb.caisse.rbcaisse.service.CaisseService;
import rb.caisse.rbcaisse.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CaisseServiceImp implements CaisseService {
    private CaisseRepository caisseRepository;
    private UserService userService;

    @Override
    public List<Caisse> getAllCaisse() {
        return caisseRepository.findAll();
    }

    @Override
    public Caisse getCaisseById(long id) {
        return caisseRepository.findById(id).get();
    }

    @Override
    public Caisse addCaisse(Caisse caisse) {
        return caisseRepository.save(caisse);
    }

    @Override
    public Caisse updateCaisse(Caisse caisse, long id) {
        caisse.setId(id);
        return caisseRepository.save(caisse);
    }

    @Override
    public void deleteCaisse(long id) {
        caisseRepository.deleteById(id);
    }

    @Override
    public List<Caisse> caissesByUser(User user) {
        String role = userService.roleUserConnected(user);
     if(role.equals("caissier")){
    List<Caisse> listeCaissesUser = new ArrayList<Caisse>();
    user.getAffaires().forEach(aff->
                    listeCaissesUser.add(aff.getCaisse()));
    return listeCaissesUser;
     }else{
    return caisseRepository.findAll();
     }
  }


}
