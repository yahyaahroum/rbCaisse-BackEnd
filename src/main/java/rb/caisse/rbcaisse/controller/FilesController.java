package rb.caisse.rbcaisse.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import rb.caisse.rbcaisse.entity.PJAlimentationCaisse;
import rb.caisse.rbcaisse.entity.FileInfo;
import rb.caisse.rbcaisse.message.ResponseMessage;
import rb.caisse.rbcaisse.service.FilesStorageService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/Files")
public class FilesController {

    @Autowired
    private FilesStorageService storageService;

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

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @DeleteMapping("/deleteFiles/{filename}")
    public ResponseEntity<ResponseMessage> deleteFile(@PathVariable String filename) {
        String message = "";
        try {
            boolean existed = storageService.delete(filename);

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
    @GetMapping("/filesByAlimentation/{id}")
    public List<PJAlimentationCaisse> getFilesByAlimentation(@PathVariable("id") String id) {
        if(!id.equals("undefined"))
            return storageService.allFilesByAlimentation(Long.parseLong(id));
        else
            return null;
    }
    @PostMapping("savePjAlimentationById/{id}")
    ResponseEntity<ResponseMessage> savePjAlimentation(@PathVariable("id") long id,
                                             @RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.savePjAlimentationById(id,file);
            message = "Le fichier a été téléchargé avec succès: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Impossible de télécharger le fichier: " + file.getOriginalFilename() + ". Erreur: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
}
