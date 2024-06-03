package rb.caisse.rbcaisse.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.NatureAlimentation;
import rb.caisse.rbcaisse.entity.NatureAlimentation;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.NatureAlimentationService;
import rb.caisse.rbcaisse.service.NatureAlimentationService;

import java.util.List;

@RestController
@RequestMapping("/api/naturealimentation")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class NatureAlimentationController {

    private NatureAlimentationService natureAlimentationService;
    @GetMapping("/getAll")
    public List<NatureAlimentation> getAllNatureAlimentations() {
        return natureAlimentationService.getAll();
    }

    @GetMapping("/searchById/{id}")
    public NatureAlimentation getById(@PathVariable long id) {
        return natureAlimentationService.findNatureById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody NatureAlimentation NatureAlimentation ) {
        natureAlimentationService.addNature(NatureAlimentation);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody NatureAlimentation NatureAlimentation){
        natureAlimentationService.updateNature(NatureAlimentation,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        natureAlimentationService.deleteNature(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }

}

