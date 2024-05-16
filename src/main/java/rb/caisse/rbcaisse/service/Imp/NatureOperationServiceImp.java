package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.NatureOperation;
import rb.caisse.rbcaisse.repository.NatureOperationRepository;
import rb.caisse.rbcaisse.service.NatureOperationService;

import java.util.List;

@Service
@AllArgsConstructor
public class NatureOperationServiceImp implements NatureOperationService {
    private NatureOperationRepository natureOperationRepository;
    @Override
    public List<NatureOperation> getAllNatureOperation() {
        return natureOperationRepository.findAll();
    }

    @Override
    public NatureOperation getNatureOperationById(long id) {
        return natureOperationRepository.findById(id).get();
    }

    @Override
    public NatureOperation addNatureOperation(NatureOperation natureOperation) {
        return natureOperationRepository.save(natureOperation);
    }

    @Override
    public NatureOperation updateNatureOperation(NatureOperation natureOperation, long id) {
        natureOperation.setId(id);
        return natureOperationRepository.save(natureOperation);
    }

    @Override
    public void deleteNatureOperation(long id) {
        natureOperationRepository.deleteById(id);
    }
}
