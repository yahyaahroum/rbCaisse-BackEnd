package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.NatureOperation;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.NatureOperationService;

import java.util.List;

@RestController
@RequestMapping("/api/natureoperation")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class NatureOperationController {
    private NatureOperationService natureOperationService;
    @GetMapping("/getAll")
    public List<NatureOperation> getAllNatureOperations() {
        return natureOperationService.getAllNatureOperation();
    }

    @GetMapping("/searchById/{id}")
    public NatureOperation getById(@PathVariable long id) {
        return natureOperationService.getNatureOperationById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody NatureOperation natureOperation ) {
        natureOperationService.addNatureOperation(natureOperation);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody NatureOperation natureOperation){
        natureOperationService.updateNatureOperation(natureOperation,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        natureOperationService.deleteNatureOperation(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }

}


