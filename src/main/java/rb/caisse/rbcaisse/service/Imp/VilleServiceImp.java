package rb.caisse.rbcaisse.service.Imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.Ville;

import rb.caisse.rbcaisse.repository.VilleRepository;

import rb.caisse.rbcaisse.service.VilleService;

import java.util.List;
@Service
public class VilleServiceImp implements VilleService {
    @Autowired
    private VilleRepository VilleRepository;
    @Override
    public List<Ville> getAllVilles() {
        return VilleRepository.findAll();
    }

    @Override
    public Ville getVilleById(long id) {
        return VilleRepository.findById(id).get();
    }

    @Override
    public Ville addVille(Ville ville) {
        return VilleRepository.save(ville);
    }

    @Override
    public Ville updateVille(Ville ville, long id) {
        ville.setId(id);
        return VilleRepository.save(ville);
    }

    @Override
    public void deleteVille(long id) {
        VilleRepository.deleteById(id);
    }




}
