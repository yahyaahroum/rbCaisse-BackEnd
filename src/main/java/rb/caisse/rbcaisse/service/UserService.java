package rb.caisse.rbcaisse.service;



import rb.caisse.rbcaisse.entity.Role;
import rb.caisse.rbcaisse.entity.User;
import rb.caisse.rbcaisse.payload.request.SignupRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(SignupRequest signUpRequest);
    public User updateUser(User user,long id);
    public List<User> getAllUsers();
    public User finduserById(Long id);
    public Boolean deleteUser(Long id);
    public Optional<User> findbyusername();
    public List<User> finuserbyrole(Pageable pageable, List<Role> roles);
    public void sessionUser(long id);
    public Optional<User> getUserById(Long id);
    public boolean findUsernameExiste(String username);
    public boolean findEmailExiste(String email);
    public void updatePassword(long id,String newPassword);
    public boolean isValidPassword(long id,String password);






}
