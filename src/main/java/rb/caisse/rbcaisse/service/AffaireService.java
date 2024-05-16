package rb.caisse.rbcaisse.service;

import org.springframework.http.ResponseEntity;
import rb.caisse.rbcaisse.entity.Affaire;

import java.util.List;

public interface AffaireService {
     List<Affaire> getAllAffaires();
     Affaire getAffaireById(long id);
     Affaire addAffaire(Affaire affaire);
     Affaire updateAffaire(Affaire affaire,long id);
     void deleteAffaire(long id);
     Affaire findAffaireByCode(String codeAffaire);
    List<Affaire> getAffairesByUser(long id);
}
