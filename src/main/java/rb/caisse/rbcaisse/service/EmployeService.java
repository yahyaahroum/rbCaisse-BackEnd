package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.Employe;

import java.util.List;

public interface EmployeService {
    List<Employe> getAllEmploye();
    Employe EmployeById(long id);
    Employe addEmploye(Employe employe);
    Employe updateEmploye(Employe employe,long id);
    void deleteEmploye(long id);
}
