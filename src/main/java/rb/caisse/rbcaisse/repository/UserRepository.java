package rb.caisse.rbcaisse.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rb.caisse.rbcaisse.entity.Role;
import rb.caisse.rbcaisse.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  List<User> findAllByRolesIn(List<Role> roles);
   User findFirstByOrderByIdAsc();



}

