package rb.caisse.rbcaisse.repository;

import java.util.Optional;


import rb.caisse.rbcaisse.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional<Role> findByName(String name);

}
