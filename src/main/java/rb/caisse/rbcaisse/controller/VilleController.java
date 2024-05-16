package rb.caisse.rbcaisse.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.Ville;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.VilleService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping("/api/ville")

public class VilleController {

    private VilleService villeService;

    @GetMapping("/getAll")
    public List<Ville> getAllVilles() {
        return villeService.getAllVilles();
    }

    @GetMapping("/searchById/{id}")
    public Ville getVilleById(@PathVariable long id) {
        return villeService.getVilleById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody Ville ville) {
        villeService.addVille(ville);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Ville ville){
        villeService.updateVille(ville,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        villeService.deleteVille(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }


}

