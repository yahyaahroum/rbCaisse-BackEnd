package rb.caisse.rbcaisse.service.Imp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.entity.Employe;
import rb.caisse.rbcaisse.repository.EmployeRepository;
import rb.caisse.rbcaisse.service.EmployeService;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceImp implements EmployeService {
    private EmployeRepository employeRepository;
    @Override
    public List<Employe> getAllEmploye() {
        return employeRepository.findAll();
    }

    @Override
    public Employe EmployeById(long id) {
        return employeRepository.findById(id).get();
    }

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe updateEmploye(Employe employe, long id) {
        employe.setId(id);
        return employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(long id) {
        employeRepository.deleteById(id);
    }
}
