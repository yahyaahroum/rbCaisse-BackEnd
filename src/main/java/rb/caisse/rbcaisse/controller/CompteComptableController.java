package rb.caisse.rbcaisse.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.CompteComptable;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.CompteComptableService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comptecomptable")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class CompteComptableController {

    private CompteComptableService compteComptableService;
    @GetMapping("/getAll")
    public List<CompteComptable> getAllCaisses() {
        return compteComptableService.getAllCompteComptable();
    }

    @GetMapping("/searchById/{id}")
    public Optional<CompteComptable> getCaisseById(@PathVariable long id) {
        return compteComptableService.getCompteComptableById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody CompteComptable compteComptable) {
        compteComptableService.addCompteComptable(compteComptable);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody CompteComptable compteComptable){
        compteComptableService.updateCompteComptable(compteComptable,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        compteComptableService.deleteCompteComptable(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }

}



