package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.Banque;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.BanqueService;

import java.util.List;

@RestController
@RequestMapping("/api/banque")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class BanqueController {
    private BanqueService banqueService;
    @GetMapping("/getAll")
    public List<Banque> getAllBanques() {
        return banqueService.getAllBanque();
    }

    @GetMapping("/searchById/{id}")
    public Banque getBanqueById(@PathVariable long id) {
        return banqueService.getBanqueById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody Banque Banque) {
        banqueService.addBanque(Banque);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Banque Banque){
        banqueService.updateBanque(Banque,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        banqueService.deleteBanque(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }
}


