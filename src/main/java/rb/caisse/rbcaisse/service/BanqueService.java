package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.Banque;

import java.util.List;

public interface BanqueService {
    List<Banque> getAllBanque();
    Banque getBanqueById(long id);
    Banque addBanque(Banque banque);
    Banque updateBanque(Banque banque, long id);
    void deleteBanque(long id);
}
