package rb.caisse.rbcaisse.service.Imp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.NatureAlimentation;
import rb.caisse.rbcaisse.repository.NatureAlimentationRepository;
import rb.caisse.rbcaisse.service.NatureAlimentationService;

import java.util.List;
@Service
@AllArgsConstructor
public class NatureAlimentationServiceImp implements NatureAlimentationService {
    private NatureAlimentationRepository natureAlimentationRepository;
    @Override
    public List<NatureAlimentation> getAll() {
        return natureAlimentationRepository.findAll();
    }

    @Override
    public NatureAlimentation findNatureById(long id) {
        return natureAlimentationRepository.findById(id).get();
    }

    @Override
    public NatureAlimentation addNature(NatureAlimentation natureAlimentation) {
        return natureAlimentationRepository.save(natureAlimentation);
    }

    @Override
    public NatureAlimentation updateNature(NatureAlimentation natureAlimentation, long id) {
        natureAlimentation.setId(id);
        return natureAlimentationRepository.save(natureAlimentation);
    }

    @Override
    public void deleteNature(long id) {
      natureAlimentationRepository.deleteById(id);
    }
}
