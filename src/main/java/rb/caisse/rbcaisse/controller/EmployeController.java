package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.Employe;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.EmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employe")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class EmployeController {
    private EmployeService employeService;
    @GetMapping("/getAll")
    public List<Employe> getAllEmployes() {
        return employeService.getAllEmploye();
    }

    @GetMapping("/searchById/{id}")
    public Employe getEmployeById(@PathVariable long id) {
        return employeService.EmployeById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody Employe Employe) {
        employeService.addEmploye(Employe);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Employe Employe){
        employeService.updateEmploye(Employe,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        employeService.deleteEmploye(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }


}


