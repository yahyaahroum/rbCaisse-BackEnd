package rb.caisse.rbcaisse.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rb.caisse.rbcaisse.entity.Affaire;
import rb.caisse.rbcaisse.entity.Role;
import rb.caisse.rbcaisse.entity.User;
import rb.caisse.rbcaisse.message.ResponseMessage;
import rb.caisse.rbcaisse.payload.request.SignupRequest;
import rb.caisse.rbcaisse.service.AffaireService;
import rb.caisse.rbcaisse.service.RoleService;
import rb.caisse.rbcaisse.service.UserService;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
//@PreAuthorize("hasAnyAuthority('admin')")
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    private AffaireService affaireService;
    private RoleService roleService;



    //@PreAuthorize("hasAnyAuthority('admin')")
    @PostMapping("/addUser")
    public User AddUser(@RequestBody SignupRequest user){

        return userService.saveUser(user);
    }

    @GetMapping("/Liste")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable("id") Long id,@RequestBody User user){
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/Supprimer/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);

    }
    @GetMapping("/userById/{id}")
    public User getUserById(@PathVariable long id){

        return userService.finduserById(id);
    }

    @PostMapping("/addRoles/{id}")
    public void AddRolesUser(@PathVariable long id,@RequestBody String role){

        User user=userService.finduserById(id);
        Role roleUser=roleService.getRoleByName(role);
        List<Role> roles = user.getRoles();
        roles.add(roleUser);
        user.setRoles(roles);
        System.out.println(user.getRoles());
        userService.updateUser(user,id);
    }
    @PostMapping("/addAffaires/{id}")
    public void addAffairesUser(@PathVariable long id,@RequestBody String codeAffaire){
        User user=userService.finduserById(id);
        Affaire affaireUser=affaireService.findAffaireByCode(codeAffaire);
        List<Affaire> affaires = user.getAffaires();
        affaires.add(affaireUser);
        user.setAffaires(affaires);
        System.out.println(user);
        userService.updateUser(user,id);
    }

   /* @GetMapping("/affairesUserbyId/{id}")
    public List<DemandeAchat> getAffaireByUser(@PathVariable long id){
        List<DemandeAchat> listeDAByUser=new ArrayList<>();
        User user=userService.finduserById(id);
        List<Affaire> listeAffaireUser=user.getAffaires();
        List<Role> listeRoles= user.getRoles();
        boolean isAcheteur=listeRoles.stream().anyMatch(a->a.getName().equals("acheteur"));
       if(isAcheteur){
           List<DemandeAchat> listeDAByAffaire=new ArrayList<>();
           for(Affaire affaire:listeAffaireUser){
               listeDAByAffaire=demandeAchatService.findByChantier(affaire);
               listeDAByUser.addAll(listeDAByAffaire);
       }
           return listeDAByUser;

        }
       return demandeAchatService.getAllDa();
    }*/
    @GetMapping("/sessionUser/{id}")
    public ResponseEntity<ResponseMessage> updateSessionUser(@PathVariable long id){
    String message = "";
        try {
        userService.sessionUser(id);
        message = "La session est modifié avec succès: ";
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
        message = "Impossible de modifier cette session . Erreur: " + e.getMessage();
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
}
   @GetMapping("/existeByUsername/{username}")
    public boolean existeByUsername(@PathVariable String username){
        return userService.findUsernameExiste(username);
   }
    @GetMapping("/existeByEmail/{email}")
    public boolean existeByEmail(@PathVariable String email){
        return userService.findEmailExiste(email);
    }
    @PutMapping("/changePassword/{id}")
    public ResponseEntity<ResponseMessage> updatePasswordUser(@PathVariable long id,@RequestBody String newPassword){
        String message = "";
        try {
            userService.updatePassword(id,newPassword);
            message = "La mot de passe est modifié avec succès: ";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Impossible de modifier le mot de passe . Erreur: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @PostMapping("/verificationPassword/{id}")
    public boolean passwordIsValid(@PathVariable long id,@RequestBody String password){
        return userService.isValidPassword(id,password);
    }
}
