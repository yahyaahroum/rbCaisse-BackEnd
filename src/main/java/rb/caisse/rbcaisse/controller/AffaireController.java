package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.Affaire;
import rb.caisse.rbcaisse.entity.User;
import rb.caisse.rbcaisse.payload.request.SignupRequest;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.AffaireService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping("/api/affaire")

public class AffaireController {

    private AffaireService affaireService;

    @GetMapping("/getAll")
    public List<Affaire> getAllAffaires() {
        return affaireService.getAllAffaires();
    }

    @GetMapping("/searchById/{id}")
    public Affaire getAffaireById(@PathVariable long id) {
        return affaireService.getAffaireById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody Affaire affaire) {
          affaireService.addAffaire(affaire);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Affaire affaire){
         affaireService.updateAffaire(affaire,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        affaireService.deleteAffaire(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }

    @GetMapping("/affaireByUser/{id}")
    public List<Affaire> getAffaireByUser(@PathVariable long id) {
        return affaireService.getAffairesByUser(id);
    }
}

