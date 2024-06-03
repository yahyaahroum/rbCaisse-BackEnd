package rb.caisse.rbcaisse.service.Imp;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import rb.caisse.rbcaisse.config.GlobalVariableConfig;
import rb.caisse.rbcaisse.entity.AlimentationCaisse;
import rb.caisse.rbcaisse.entity.PJAlimentationCaisse;
import rb.caisse.rbcaisse.entity.SuiviCaisse;
import rb.caisse.rbcaisse.repository.AlimentationCaisseRepository;
import rb.caisse.rbcaisse.repository.PJAlimentationCaisseRepository;
import rb.caisse.rbcaisse.repository.SuiviCaisseRepository;
import rb.caisse.rbcaisse.service.FilesStorageService;


@Service
@AllArgsConstructor
public class FilesStorageServiceImpl implements FilesStorageService {
    private PJAlimentationCaisseRepository pjRepository;
    private AlimentationCaisseRepository alimentationCaisseRepository;
    private GlobalVariableConfig globalVariableConfig;
    private SuiviCaisseRepository suiviCaisseRepository;
    @Override
    public void init() {
        try {
            Path root = Paths.get(globalVariableConfig.getGlobalVariable());
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Impossible d'initialiser le dossier pour le téléchargement !");
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
     /*String pieceJointe = UUID.randomUUID().toString();
      String extension = "."+FilenameUtils.getExtension(file.getOriginalFilename());
      Files.copy(file.getInputStream(), this.root.resolve(pieceJointe+extension));*//*
      long idFile=0;
      DemandeAchat demandeAchat=demandeAchatRepository.findFirstByOrderByIdDesc();
      List<Fichiers> listeFichiers=fichiersRepository.findAllByGroupId(demandeAchat.getPjDa());
      if(listeFichiers.size()>0) {
        idFile = listeFichiers.get(listeFichiers.size() - 1).getFileId();
      }
      if(idFile<3){
        long namefileid=idFile+1;
        String extension = "."+FilenameUtils.getExtension(file.getOriginalFilename());
        Files.copy(file.getInputStream(), this.root.resolve(demandeAchat.getPjDa()+"-"+namefileid+extension));
       // Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        Fichiers fichiers=new Fichiers();
        fichiers.setName(demandeAchat.getPjDa()+"-"+namefileid+extension);
        fichiers.setGroupId(demandeAchat.getPjDa());
        fichiers.setFileId(idFile+1);
        fichiersRepository.save(fichiers);
      }*/
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("Un fichier de ce nom existe déjà.");
            }

            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path root = Paths.get(globalVariableConfig.getGlobalVariable());
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Impossible de lire le fichier !");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Erreur: " + e.getMessage());
        }
    }


    @Override
    public boolean delete(String filename) {
      try {
            Path root = Paths.get(globalVariableConfig.getGlobalVariable());
            PJAlimentationCaisse fichiers=pjRepository.findByFileName(filename);
            pjRepository.deleteById(fichiers.getId());
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Erreur: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        Path root = Paths.get(globalVariableConfig.getGlobalVariable());
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            Path root = Paths.get(globalVariableConfig.getGlobalVariable());
            return Files.walk(root, 1).filter(path -> !path.equals(root)).map(root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Impossible de lire le fichier !");
        }
    }

    @Override
    public List<PJAlimentationCaisse> allFilesByAlimentation(long id) {
        AlimentationCaisse alimentation=alimentationCaisseRepository.findById(id).get();
        return pjRepository.findAllByAlimentationCaisse_Id(id);
    }


    @Override
    public void savePjAlimentationById(long id,MultipartFile file) throws IOException {
        try{
            PJAlimentationCaisse pj=new PJAlimentationCaisse();
            AlimentationCaisse ac=alimentationCaisseRepository.findById(id).get();
            Path dossierPiecesJointes = Paths.get(globalVariableConfig.getGlobalVariable());
            if (Files.notExists(dossierPiecesJointes)) {

                Files.createDirectory(dossierPiecesJointes);
            }
            String pieceJointe = null;

            if(file.getSize()!=0)
            {
                pieceJointe = UUID.randomUUID().toString();
                String extension = "."+FilenameUtils.getExtension(file.getOriginalFilename());
                pj.setFileName(pieceJointe+ extension);
                pj.setDatePJ(new Date());
                pj.setAlimentationCaisse(ac);
                pjRepository.save(pj);

                Files.copy(file.getInputStream(), dossierPiecesJointes.resolve(pieceJointe+ extension));
            }
           /* else
            {
                if(pj.getId() != null)  // Check IF IS UPDATE OPERATION OR INSERT
                {
                    pj.setFileName(pjRepository.findById(pj.getId()).get().getFileName());
                }
            }*/


        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("Un fichier de ce nom existe déjà.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public boolean deletePJSuiviCaisse(String filename) {
        try {
            if(!filename.equals("")){
                Path root = Paths.get(globalVariableConfig.getGlobalVariable());
                SuiviCaisse suivi=suiviCaisseRepository.findByPieceJointe(filename);

                suivi.setPieceJointe(null);
                suiviCaisseRepository.save(suivi);
                Path file = root.resolve(filename);
                return Files.deleteIfExists(file);
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException("Erreur: " + e.getMessage());
        }
    }
    @Override
    public void savePjSuiviCaisseById(long id,MultipartFile file) throws IOException {
        try{
            SuiviCaisse suivi=suiviCaisseRepository.findById(id).get();
            Path dossierPiecesJointes = Paths.get(globalVariableConfig.getGlobalVariable());
            if (Files.notExists(dossierPiecesJointes)) {

                Files.createDirectory(dossierPiecesJointes);
            }
            String pieceJointe = null;

            if(file.getSize()!=0)
            {
                pieceJointe = UUID.randomUUID().toString();
                String extension = "."+FilenameUtils.getExtension(file.getOriginalFilename());
                suivi.setPieceJointe(pieceJointe+ extension);
               suivi.setId(id);
                suiviCaisseRepository.save(suivi);

                Files.copy(file.getInputStream(), dossierPiecesJointes.resolve(pieceJointe+ extension));
            }
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("Un fichier de ce nom existe déjà.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public void updatePjSuiviCaisseById(long id,MultipartFile file) throws IOException {
        try{
            SuiviCaisse suivi=suiviCaisseRepository.findById(id).get();
            Path dossierPiecesJointes = Paths.get(globalVariableConfig.getGlobalVariable());
            if (Files.notExists(dossierPiecesJointes)) {

                Files.createDirectory(dossierPiecesJointes);
            }
            String pieceJointe = null;

            if(file.getSize()!=0)
            {
                pieceJointe = UUID.randomUUID().toString();
                String extension = "."+FilenameUtils.getExtension(file.getOriginalFilename());
                suivi.setPieceJointe(pieceJointe+ extension);
                suivi.setId(id);
                suiviCaisseRepository.save(suivi);

                Files.copy(file.getInputStream(), dossierPiecesJointes.resolve(pieceJointe+ extension));
            }
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("Un fichier de ce nom existe déjà.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }
}
