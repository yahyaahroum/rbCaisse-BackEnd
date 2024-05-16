package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.ModeOperation;

import java.util.List;

public interface ModeOperationService {
    List<ModeOperation> getAllModeOperation();
    ModeOperation getModeOperationById(long id);
    ModeOperation addModeOperation(ModeOperation modeOperation);
    ModeOperation updateModeOperation(ModeOperation modeOperation, long id);
    void deleteModeOperation(long id);
}
