package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.CompteComptable;

import java.util.List;
import java.util.Optional;

public interface CompteComptableService {
    List<CompteComptable> getAllCompteComptable();
    Optional<CompteComptable> getCompteComptableById(long id);
    CompteComptable addCompteComptable(CompteComptable compteComptable);
    CompteComptable updateCompteComptable(CompteComptable compteComptable,long id);
    void deleteCompteComptable(long id);
}
