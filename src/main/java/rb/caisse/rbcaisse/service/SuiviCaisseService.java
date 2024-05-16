package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.SuiviCaisse;

import java.util.List;

public interface SuiviCaisseService {
    List<SuiviCaisse> getAllSuiviCaisse();
    SuiviCaisse getSuiviCaisseById(long id);
    SuiviCaisse addSuiviCaisse(SuiviCaisse suiviCaisse);
    SuiviCaisse updateSuiviCaisse(SuiviCaisse suiviCaisse,long id);
    void deleteSuiviCaisse(long id);
}
