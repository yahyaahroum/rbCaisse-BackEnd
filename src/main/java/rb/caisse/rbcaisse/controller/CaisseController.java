package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.Caisse;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.CaisseService;

import java.util.List;

@RestController
@RequestMapping("/api/caisse")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class CaisseController {
    private CaisseService caisseService;
    @GetMapping("/getAll")
    public List<Caisse> getAllCaisses() {
        return caisseService.getAllCaisse();
    }

    @GetMapping("/searchById/{id}")
    public Caisse getCaisseById(@PathVariable long id) {
        return caisseService.getCaisseById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody Caisse Caisse) {
        caisseService.addCaisse(Caisse);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Caisse Caisse){
        caisseService.updateCaisse(Caisse,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        caisseService.deleteCaisse(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }

}


