package rb.caisse.rbcaisse.service.Imp;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import rb.caisse.rbcaisse.entity.Role;
import rb.caisse.rbcaisse.entity.User;
import rb.caisse.rbcaisse.payload.request.SignupRequest;
import rb.caisse.rbcaisse.payload.response.MessageResponse;
import rb.caisse.rbcaisse.repository.RoleRepository;
import rb.caisse.rbcaisse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rb.caisse.rbcaisse.service.UserService;

import java.util.*;

@AllArgsConstructor
@Service
public class UserImpService implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    PasswordEncoder encoder;

    @Override
    public User saveUser(SignupRequest signUpRequest) {
           if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                return null;
            }

            if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                return null;

            }
        User user = new User();
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setNom(signUpRequest.getNom());
        user.setPrenom(signUpRequest.getPrenom());
        user.setSession(signUpRequest.getSession());
        user.setMatricule(signUpRequest.getMatricule());
        user.setAffaires(signUpRequest.getAffaires());
            return  userRepository.save(user) ;
        }
    @Override
    public User updateUser(User user, long id) {
        User user1=userRepository.findById(id).get();
        user1.setId(id);
        user1.setMatricule(user.getMatricule());
        user1.setNom(user.getNom());
        user1.setPrenom(user.getPrenom());
        user1.setEmail(user.getEmail());
        user1.setRoles(user.getRoles());
        user1.setAffaires(user.getAffaires());
        user1.setUsername(user.getUsername());
        return userRepository.save(user1);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public User finduserById(Long id) {

        return userRepository.findById(id).get();
    }

    @Override
    public Boolean deleteUser(Long id) {

        User user=userRepository.findById(id).get();
        user.getRoles().clear();
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<User> findbyusername() {
        Authentication aut = SecurityContextHolder.getContext().getAuthentication();
        String username = aut.getName();
        Optional<User> user = userRepository.findByUsername(username);
        return user;
    }

	@Override
	public List<User> finuserbyrole(Pageable pageable, List<Role> roles) {
		List<User> rhusers = userRepository.findAllByRolesIn(roles);
        return rhusers;
	}

    @Override
    public void sessionUser(long id) {
       User user=userRepository.findById(id).get();
        if(user.getSession().equals("Actif"))
          user.setSession("Inactif");
        else{
            user.setSession("Actif");
        }
        updateUser(user,id);
    }


    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean findUsernameExiste(String username) {
        if (userRepository.existsByUsername(username)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean findEmailExiste(String email) {
        if (userRepository.existsByEmail(email)) {
            return true;
        }
        return false;
    }

    @Override
    public void updatePassword(long id,String newPassword) {
        User user=userRepository.findById(id).get();
        user.setId(id);
        user.setPassword(encoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public boolean isValidPassword(long id, String password) {
        User user=userRepository.findById(id).get();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, user.getPassword());
    }
}
