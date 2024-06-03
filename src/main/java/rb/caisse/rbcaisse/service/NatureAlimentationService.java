package rb.caisse.rbcaisse.service;

import org.hibernate.sql.ast.tree.predicate.Junction;
import rb.caisse.rbcaisse.entity.NatureAlimentation;

import java.util.List;

public interface NatureAlimentationService {
    List<NatureAlimentation> getAll();
    NatureAlimentation findNatureById(long id);
    NatureAlimentation addNature(NatureAlimentation natureAlimentation);
    NatureAlimentation updateNature(NatureAlimentation natureAlimentation,long id);
    void deleteNature(long id);
}
