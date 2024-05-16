package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.AlimentationCaisse;

import java.util.List;

public interface AlimentationCaisseService {
    List<AlimentationCaisse> getAllAlimentationCaisse();
    AlimentationCaisse getAlimentationCaisseById(long id);
    AlimentationCaisse addAlimentationCaisse(AlimentationCaisse alimentationCaisse);
    AlimentationCaisse updateAlimentationCaisse(AlimentationCaisse alimentationCaisse,long id);
    void deleteAlimentationCaisse(long id);

}
