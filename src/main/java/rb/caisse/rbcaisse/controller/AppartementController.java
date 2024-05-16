package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.Appartement;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.AppartementService;

import java.util.List;

@RestController
@RequestMapping("/api/appartement")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class AppartementController {
    private AppartementService appartementService;
    @GetMapping("/getAll")
    public List<Appartement> getAllAppartements() {
        return appartementService.getAllAppartement();
    }

    @GetMapping("/searchById/{id}")
    public Appartement getAppartementById(@PathVariable long id) {
        return appartementService.getAppartementById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody Appartement Appartement) {
        appartementService.addAppartement(Appartement);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Appartement Appartement){
        appartementService.updateAppartement(Appartement,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        appartementService.deleteAppartement(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }
}


