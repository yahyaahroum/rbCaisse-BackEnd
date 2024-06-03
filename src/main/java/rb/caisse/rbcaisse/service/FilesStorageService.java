package rb.caisse.rbcaisse.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import rb.caisse.rbcaisse.entity.PJAlimentationCaisse;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface FilesStorageService {
    public void init();

    public void save(MultipartFile file);

    public Resource load(String filename);

    public boolean delete(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();
    public List<PJAlimentationCaisse> allFilesByAlimentation(long id);
    public void savePjAlimentationById(long id,MultipartFile file) throws IOException;
    void savePjSuiviCaisseById(long id,MultipartFile file) throws IOException;
    boolean deletePJSuiviCaisse(String filename);
    void updatePjSuiviCaisseById(long id,MultipartFile file) throws IOException;

}
