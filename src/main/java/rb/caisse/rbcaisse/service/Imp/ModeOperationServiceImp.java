package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.ModeOperation;
import rb.caisse.rbcaisse.repository.ModeOperationRepository;
import rb.caisse.rbcaisse.service.ModeOperationService;

import java.util.List;

@Service
@AllArgsConstructor
public class ModeOperationServiceImp implements ModeOperationService {
    private ModeOperationRepository modeOperationRepository;
    @Override
    public List<ModeOperation> getAllModeOperation() {
        return modeOperationRepository.findAll();
    }

    @Override
    public ModeOperation getModeOperationById(long id) {
        return modeOperationRepository.findById(id).get();
    }

    @Override
    public ModeOperation addModeOperation(ModeOperation modeOperation) {
        return modeOperationRepository.save(modeOperation);
    }

    @Override
    public ModeOperation updateModeOperation(ModeOperation modeOperation, long id) {
        modeOperation.setId(id);
        return modeOperationRepository.save(modeOperation);
    }

    @Override
    public void deleteModeOperation(long id) {
        modeOperationRepository.deleteById(id);
    }
}
