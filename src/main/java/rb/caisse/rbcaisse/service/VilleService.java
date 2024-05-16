package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.Ville;

import java.util.List;

public interface VilleService {
    List<Ville> getAllVilles();
    Ville getVilleById(long id);
    Ville addVille(Ville ville);
    Ville updateVille(Ville ville,long id);
    void deleteVille(long id);

}
