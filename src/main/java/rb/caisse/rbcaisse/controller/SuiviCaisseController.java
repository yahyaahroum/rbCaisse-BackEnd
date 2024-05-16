package rb.caisse.rbcaisse.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.SuiviCaisse;
import rb.caisse.rbcaisse.entity.SuiviCaisse;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.SuiviCaisseService;

import java.util.List;

@RestController
@RequestMapping("/api/suivicaisse")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class SuiviCaisseController {
    private SuiviCaisseService suiviCaisseService;
    @GetMapping("/getAll")
    public List<SuiviCaisse> getAllSuiviCaisses() {
        return suiviCaisseService.getAllSuiviCaisse();
    }

    @GetMapping("/searchById/{id}")
    public SuiviCaisse getSuiviCaisseById(@PathVariable long id) {
        return suiviCaisseService.getSuiviCaisseById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody SuiviCaisse SuiviCaisse) {
        suiviCaisseService.addSuiviCaisse(SuiviCaisse);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody SuiviCaisse SuiviCaisse){
        suiviCaisseService.updateSuiviCaisse(SuiviCaisse,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        suiviCaisseService.deleteSuiviCaisse(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }

}


