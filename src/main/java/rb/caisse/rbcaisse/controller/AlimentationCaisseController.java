package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.AlimentationCaisse;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.AlimentationCaisseService;

import java.util.List;

@RestController
@RequestMapping("/api/alimentation")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class AlimentationCaisseController {
    private AlimentationCaisseService alimentationCaisseService;
    
    @GetMapping("/getAll")
    public List<AlimentationCaisse> getAllCaisses() {
        return alimentationCaisseService.getAllAlimentationCaisse();
    }

    @GetMapping("/searchById/{id}")
    public AlimentationCaisse getAlimentationById(@PathVariable long id) {
        return alimentationCaisseService.getAlimentationCaisseById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody AlimentationCaisse alimentationCaisse) {
        alimentationCaisseService.addAlimentationCaisse(alimentationCaisse);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody AlimentationCaisse alimentationCaisse){
        alimentationCaisseService.updateAlimentationCaisse(alimentationCaisse,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        alimentationCaisseService.deleteAlimentationCaisse(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }
}


