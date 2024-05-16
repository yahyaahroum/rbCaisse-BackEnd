package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.PaiementLoye;
import rb.caisse.rbcaisse.entity.PaiementLoye;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.PaiementLoyeService;

import java.util.List;

@RestController
@RequestMapping("/api/paiementloye")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class PaiementLoyeController {
    private PaiementLoyeService paiementLoyeService;
    @GetMapping("/getAll")
    public List<PaiementLoye> getAllPaiementLoyes() {
        return paiementLoyeService.getAllPaiementLoye();
    }

    @GetMapping("/searchById/{id}")
    public PaiementLoye getPaiementLoyeById(@PathVariable long id) {
        return paiementLoyeService.getPaiementLoyeById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody PaiementLoye PaiementLoye) {
        paiementLoyeService.addPaiementLoye(PaiementLoye);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PaiementLoye PaiementLoye){
        paiementLoyeService.updatePaiementLoye(PaiementLoye,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        paiementLoyeService.deletePaiementLoye(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }
}


