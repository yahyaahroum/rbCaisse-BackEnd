package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.DemandeAlimentation;
import rb.caisse.rbcaisse.entity.User;
import rb.caisse.rbcaisse.repository.DemandeAlimentationRepository;
import rb.caisse.rbcaisse.repository.UserRepository;
import rb.caisse.rbcaisse.service.DemandeAlimentationService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service

public class DemandeAlimentationServiceImp implements DemandeAlimentationService {
    @Autowired
    private DemandeAlimentationRepository demandeAlimentationRepository;
    @Autowired
    private UserImpService userImpService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<DemandeAlimentation> getAllDemandeAlimentation() {
        return demandeAlimentationRepository.findAll();
    }

    @Override
    public DemandeAlimentation getDemandeAlimentationById(long id) {
        return demandeAlimentationRepository.findById(id).get();
    }

    @Override
    public DemandeAlimentation addDemandeAlimentation(DemandeAlimentation demandeAlimentation) {
        return demandeAlimentationRepository.save(demandeAlimentation);
    }

    @Override
    public DemandeAlimentation updateDemandeAlimentation(DemandeAlimentation demandeAlimentation, long id) {
        DemandeAlimentation da=getDemandeAlimentationById(id);
        da.setMontantDemande(demandeAlimentation.getMontantDemande());
        da.setCaisse(demandeAlimentation.getCaisse());
        da.setMotif(demandeAlimentation.getMotif());
        da.setType(demandeAlimentation.getType());

        //demandeAlimentation.setId(id);
        return demandeAlimentationRepository.save(da);
    }

    @Override
    public void deleteDemandeAlimentation(long id) {
        demandeAlimentationRepository.deleteById(id);
    }
    public User getCurrentUser(Principal principal) {

        String username = principal.getName();
        User user = new User();
        if (null != username) {
            user = userRepository.findByUsername(username).get();
        }

        return user;
    }
}
