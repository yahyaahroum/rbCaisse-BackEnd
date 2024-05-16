package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.PaiementLoye;

import java.util.List;

public interface PaiementLoyeService {
    List<PaiementLoye> getAllPaiementLoye();
    PaiementLoye getPaiementLoyeById(long id);
    PaiementLoye addPaiementLoye(PaiementLoye paiementLoye);
    PaiementLoye updatePaiementLoye(PaiementLoye paiementLoye, long id);
    void deletePaiementLoye(long id);
}
