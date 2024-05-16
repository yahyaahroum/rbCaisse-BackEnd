package rb.caisse.rbcaisse.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.CompteComptable;
import rb.caisse.rbcaisse.repository.CompteComptableRepository;
import rb.caisse.rbcaisse.service.CompteComptableService;

import java.util.List;
import java.util.Optional;

@Service
public class CompteComptableServiceImp implements CompteComptableService {
    @Autowired
    private CompteComptableRepository compteComptableRepository;
    @Override
    public List<CompteComptable> getAllCompteComptable() {
        return compteComptableRepository.findAll();
    }

    @Override
    public Optional<CompteComptable> getCompteComptableById(long id) {
        return compteComptableRepository.findById(id);
    }

    @Override
    public CompteComptable addCompteComptable(CompteComptable compteComptable) {
        return compteComptableRepository.save(compteComptable);
    }

    @Override
    public CompteComptable updateCompteComptable(CompteComptable compteComptable, long id) {
        compteComptable.setId(id);
        return compteComptableRepository.save(compteComptable);
    }

    @Override
    public void deleteCompteComptable(long id) {
        compteComptableRepository.deleteById(id);
    }
}
