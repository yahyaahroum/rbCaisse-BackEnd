package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.Caisse;

import java.util.List;

public interface CaisseService {
    List<Caisse> getAllCaisse();
    Caisse getCaisseById(long id);
    Caisse addCaisse(Caisse caisse);
    Caisse updateCaisse(Caisse caisse,long id);
    void deleteCaisse(long id);
}
