package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.ModeOperation;
import rb.caisse.rbcaisse.entity.ModeOperation;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.ModeOperationService;

import java.util.List;

@RestController
@RequestMapping("/api/modeoperation")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ModeOperationController {
    private ModeOperationService modeOperationService;
    @GetMapping("/getAll")
    public List<ModeOperation> getAllModeOperations() {
        return modeOperationService.getAllModeOperation();
    }

    @GetMapping("/searchById/{id}")
    public ModeOperation getModeOperationById(@PathVariable long id) {
        return modeOperationService.getModeOperationById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> register(@RequestBody ModeOperation ModeOperation) {
        modeOperationService.addModeOperation(ModeOperation);
        return  ResponseEntity.ok(new MessageResponse("Insertion réussi !"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ModeOperation ModeOperation){
        modeOperationService.updateModeOperation(ModeOperation,id);
        return  ResponseEntity.ok(new MessageResponse("Modification réussi !"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        modeOperationService.deleteModeOperation(id);
        return  ResponseEntity.ok(new MessageResponse("Supression réussi !"));
    }

}


