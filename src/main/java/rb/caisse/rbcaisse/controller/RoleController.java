package rb.caisse.rbcaisse.controller;

import lombok.AllArgsConstructor;
import rb.caisse.rbcaisse.entity.Role;
import rb.caisse.rbcaisse.service.RoleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping("/api/role")
public class RoleController {
    private RoleService roleService;
    @PostMapping("/addRole")
    /*    @PreAuthorize("hasAnyAuthority('admin')")*/
    public Role AddRoler(@RequestBody Role role){

        return  roleService.addRole(role);
    }
    @GetMapping("/ListeRoles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/roleById/{id}")
    /*  @PreAuthorize("hasAnyAuthority('admin')")*/
    public Optional<Role> getRoleById(@PathVariable int id) {
        return roleService.getRoleById(id);
    }

    @PostMapping("/updateRole/{id}")
/*    @PreAuthorize("hasAnyAuthority('admin')")*/
    public Role updateRole(@PathVariable("id") int id,@RequestBody Role role){

        return  roleService.updateRole(role,id);
    }

    @GetMapping("/deleteRoleById/{id}")
  /*  @PreAuthorize("hasAnyAuthority('admin')")*/
    public void deleteRole(@PathVariable("id") int id){
        roleService.deleteRole(id);

    }
    @GetMapping("/roleByUserName/{name}")
    public Role getRoleByUserName(@PathVariable String name){
        return roleService.getRoleByName(name);
    }
}

