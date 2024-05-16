package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.AlimentationCaisse;
import rb.caisse.rbcaisse.entity.AlimentationCaisse;
import rb.caisse.rbcaisse.entity.DemandeAlimentation;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.DemandeAlimentationService;

import java.util.List;

@RestController
@RequestMapping("/api/demandealimentation")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class DemandeAlimentationController {
    private DemandeAlimentationService demandeAlimentationService;
    @GetMapping("/getAll")
    public List<DemandeAlimentation> getAllDemandeAlimentationCaisses() {
        return demandeAlimentationService.getAllDemandeAlimentation();
    }

    @GetMapping("/searchById/{id}")
    public DemandeAlimentation getDemandeAlimentationCaisseById(@PathVariable long id) {
        return demandeAlimentationService.getDemandeAlimentationById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody DemandeAlimentation demandeAlimentation) {
        demandeAlimentationService.addDemandeAlimentation(demandeAlimentation);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DemandeAlimentation demandeAlimentation){
        demandeAlimentationService.updateDemandeAlimentation(demandeAlimentation,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        demandeAlimentationService.deleteDemandeAlimentation(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }

}


