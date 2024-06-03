package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.AlimentationCaisse;
import rb.caisse.rbcaisse.entity.User;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.AlimentationCaisseService;
import rb.caisse.rbcaisse.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/alimentation")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class AlimentationCaisseController {
    private AlimentationCaisseService alimentationCaisseService;
    private UserService userService;

    @GetMapping("/getAll")
    public List<AlimentationCaisse> getAlimentationCaisses() {
        return alimentationCaisseService.getAllAlimentationCaisse();
    }

    @GetMapping("/searchById/{id}")
    public AlimentationCaisse getAlimentationCaisseById(@PathVariable long id) {
        return alimentationCaisseService.getAlimentationCaisseById(id);
    }

    @PostMapping("/add/{idUser}")
    public AlimentationCaisse register(@PathVariable long idUser,@RequestBody AlimentationCaisse alimentationCaisse) {
        User userConnecte=userService.finduserById(idUser);
        alimentationCaisse.setDemandePar(userConnecte);
        alimentationCaisseService.addAlimentationCaisse(alimentationCaisse);
        return   alimentationCaisseService.addAlimentationCaisse(alimentationCaisse);
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
    @PostMapping("/statutDemande/{id}")
    public ResponseEntity<?> statutDemande(@PathVariable long id,@RequestBody String statut) {
        alimentationCaisseService.statutAlimentationCaisse(id,statut);
        return  ResponseEntity.ok(new MessageResponse("Validation réussi !"));
    }
}


