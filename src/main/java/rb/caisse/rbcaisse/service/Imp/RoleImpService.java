package rb.caisse.rbcaisse.service.Imp;

import rb.caisse.rbcaisse.entity.Role;
import rb.caisse.rbcaisse.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.service.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleImpService implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> getRoleById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role updateRole(Role role, int id) {
        role.setId(id);
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role getRoleByName(String name) {

        return roleRepository.findByName(name).get();
    }
}
