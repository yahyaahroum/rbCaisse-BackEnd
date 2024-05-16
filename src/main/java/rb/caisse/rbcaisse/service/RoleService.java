package rb.caisse.rbcaisse.service;

import rb.caisse.rbcaisse.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    public List<Role> getAllRoles();
    public Role addRole(Role role);
    public Optional<Role> getRoleById(int id);
    public Role updateRole(Role role,int id);
    public void deleteRole(int id);
    public Role getRoleByName(String name);

}
