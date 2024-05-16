package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.DemandeAlimentation;

import java.util.List;

public interface DemandeAlimentationService {
    List<DemandeAlimentation> getAllDemandeAlimentation();
    DemandeAlimentation getDemandeAlimentationById(long id);
    DemandeAlimentation addDemandeAlimentation(DemandeAlimentation demandeAlimentation);
    DemandeAlimentation updateDemandeAlimentation(DemandeAlimentation demandeAlimentation, long id);
    void deleteDemandeAlimentation(long id);
}
