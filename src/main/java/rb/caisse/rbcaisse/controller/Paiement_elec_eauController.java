package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.Paiement_elec_eau;
import rb.caisse.rbcaisse.entity.Paiement_elec_eau;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.Paiement_elec_eauService;

import java.util.List;

@RestController
@RequestMapping("/api/paiementeleceau")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class Paiement_elec_eauController {
    private Paiement_elec_eauService paiement_elec_eauService;
    @GetMapping("/getAll")
    public List<Paiement_elec_eau> getAllPaiement_elec_eaus() {
        return paiement_elec_eauService.getAllPaiement_elec_eau();
    }

    @GetMapping("/searchById/{id}")
    public Paiement_elec_eau getPaiement_elec_eauById(@PathVariable long id) {
        return paiement_elec_eauService.getPaiement_elec_eauById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody Paiement_elec_eau Paiement_elec_eau) {
        paiement_elec_eauService.addPaiement_elec_eau(Paiement_elec_eau);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Paiement_elec_eau Paiement_elec_eau){
        paiement_elec_eauService.updatePaiement_elec_eau(Paiement_elec_eau,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        paiement_elec_eauService.deletePaiement_elec_eau(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }

}


