package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.Fonction;
import rb.caisse.rbcaisse.entity.Fonction;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.FonctionService;

import java.util.List;

@RestController
@RequestMapping("/api/fonction")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class FonctionController {
    private FonctionService fonctionService;
    @GetMapping("/getAll")
    public List<Fonction> getAllFonctions() {
        return fonctionService.getAllFonction();
    }

    @GetMapping("/searchById/{id}")
    public Fonction getFonctionById(@PathVariable long id) {
        return fonctionService.FonctionById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody Fonction Fonction) {
        fonctionService.addFonction(Fonction);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Fonction Fonction){
        fonctionService.updateFonction(Fonction,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        fonctionService.deleteFonction(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }

}


