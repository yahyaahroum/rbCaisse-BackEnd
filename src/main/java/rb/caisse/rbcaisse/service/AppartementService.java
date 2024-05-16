package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.AlimentationCaisse;
import rb.caisse.rbcaisse.entity.Appartement;

import java.util.List;

public interface AppartementService {
    List<Appartement> getAllAppartement();
    Appartement getAppartementById(long id);
    Appartement addAppartement(Appartement appartement);
    Appartement updateAppartement(Appartement appartement,long id);
    void deleteAppartement(long id);
}
