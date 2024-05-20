package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.AlimentationCaisse;
import rb.caisse.rbcaisse.entity.AlimentationCaisse;
import rb.caisse.rbcaisse.entity.DemandeAlimentation;
import rb.caisse.rbcaisse.entity.User;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.DemandeAlimentationService;
import rb.caisse.rbcaisse.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/demandealimentation")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class DemandeAlimentationController {
    private DemandeAlimentationService demandeAlimentationService;
    private UserService userService;
    @GetMapping("/getAll")
    public List<DemandeAlimentation> getAllDemandeAlimentationCaisses() {
        return demandeAlimentationService.getAllDemandeAlimentation();
    }

    @GetMapping("/searchById/{id}")
    public DemandeAlimentation getDemandeAlimentationCaisseById(@PathVariable long id) {
        return demandeAlimentationService.getDemandeAlimentationById(id);
    }

    @PostMapping("/add/{idUser}")
    public ResponseEntity<?> register(@PathVariable long idUser,@RequestBody DemandeAlimentation demandeAlimentation) {
        User userConnecte=userService.finduserById(idUser);
        demandeAlimentation.setUser(userConnecte);
        demandeAlimentationService.addDemandeAlimentation(demandeAlimentation);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DemandeAlimentation demandeAlimentation){
        demandeAlimentationService.updateDemandeAlimentation(demandeAlimentation,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        demandeAlimentationService.deleteDemandeAlimentation(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }

}


