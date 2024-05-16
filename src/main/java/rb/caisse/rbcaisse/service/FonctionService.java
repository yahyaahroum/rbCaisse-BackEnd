package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.Fonction;

import java.util.List;

public interface FonctionService {
    List<Fonction> getAllFonction();
    Fonction FonctionById(long id);
    Fonction addFonction(Fonction fonction);
    Fonction updateFonction(Fonction fonction,long id);
    void deleteFonction(long id);
}
