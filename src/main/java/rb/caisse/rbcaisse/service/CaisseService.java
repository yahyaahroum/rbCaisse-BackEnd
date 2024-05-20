package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.Caisse;
import rb.caisse.rbcaisse.entity.User;

import java.util.List;

public interface CaisseService {
    List<Caisse> getAllCaisse();
    Caisse getCaisseById(long id);
    Caisse addCaisse(Caisse caisse);
    Caisse updateCaisse(Caisse caisse,long id);
    void deleteCaisse(long id);
    List<Caisse> caissesByUser(User user);
}
