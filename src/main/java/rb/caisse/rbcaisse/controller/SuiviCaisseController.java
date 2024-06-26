package rb.caisse.rbcaisse.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rb.caisse.rbcaisse.entity.SuiviCaisse;
import rb.caisse.rbcaisse.entity.SuiviCaisse;
import rb.caisse.rbcaisse.message.ResponseMessage;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.service.FilesStorageService;
import rb.caisse.rbcaisse.service.SuiviCaisseService;

import java.util.List;

@RestController
@RequestMapping("/api/suivicaisse")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class SuiviCaisseController {
    private SuiviCaisseService suiviCaisseService;
    private FilesStorageService storageService;
    @GetMapping("/getAll")
    public List<SuiviCaisse> getAllSuiviCaisses() {
        return suiviCaisseService.getAllSuiviCaisse();
    }

    @GetMapping("/searchById/{id}")
    public SuiviCaisse getSuiviCaisseById(@PathVariable long id) {
        return suiviCaisseService.getSuiviCaisseById(id);
    }

    @PostMapping("/add")
    public SuiviCaisse register(@RequestBody SuiviCaisse SuiviCaisse) {
        return suiviCaisseService.addSuiviCaisse(SuiviCaisse);
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
    @PostMapping("savePjSuiviCaisseById/{id}")
    ResponseEntity<ResponseMessage> savePjSuiviCaisse(@PathVariable("id") long id,
                                                       @RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.savePjSuiviCaisseById(id,file);
            message = "Le fichier a été téléchargé avec succès: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Impossible de télécharger le fichier: " + file.getOriginalFilename() + ". Erreur: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @DeleteMapping("/deleteFiles/{filename}")
    public ResponseEntity<ResponseMessage> deleteFileSuiviCaisse(@PathVariable String filename) {
        String message = "";
        try {
            boolean existed = storageService.deletePJSuiviCaisse(filename);

            if (existed) {
                message = "Fichier supprimé aves succés: " + filename;
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            }

            message = "Le fichier n'existe pas!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Impossible de supprimer le fichier: " + filename + ". Erreur: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(message));
        }
    }
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.save(file);
            message = "Le fichier a été téléchargé avec succès: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Impossible de télécharger le fichier: " + file.getOriginalFilename() + ". Erreur: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
}


