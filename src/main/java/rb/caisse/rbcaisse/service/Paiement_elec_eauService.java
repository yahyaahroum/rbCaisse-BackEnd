package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.Paiement_elec_eau;

import java.util.List;

public interface Paiement_elec_eauService {
    List<Paiement_elec_eau> getAllPaiement_elec_eau();
    Paiement_elec_eau getPaiement_elec_eauById(long id);
    Paiement_elec_eau addPaiement_elec_eau(Paiement_elec_eau paiementElecEau);
    Paiement_elec_eau updatePaiement_elec_eau(Paiement_elec_eau paiementElecEau, long id);
    void deletePaiement_elec_eau(long id);
}
