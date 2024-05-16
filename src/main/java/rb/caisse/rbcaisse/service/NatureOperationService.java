package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.NatureOperation;

import java.util.List;

public interface NatureOperationService {
    List<NatureOperation> getAllNatureOperation();
    NatureOperation getNatureOperationById(long id);
    NatureOperation addNatureOperation(NatureOperation natureOperation);
    NatureOperation updateNatureOperation(NatureOperation natureOperation, long id);
    void deleteNatureOperation(long id);
}
