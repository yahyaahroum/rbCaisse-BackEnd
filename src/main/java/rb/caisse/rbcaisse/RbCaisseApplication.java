package rb.caisse.rbcaisse;


import lombok.AllArgsConstructor;
import rb.caisse.rbcaisse.config.GlobalVariableConfig;

import rb.caisse.rbcaisse.entity.Role;
import rb.caisse.rbcaisse.entity.User;
import rb.caisse.rbcaisse.repository.RoleRepository;
import rb.caisse.rbcaisse.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EnableConfigurationProperties(GlobalVariableConfig.class)
@SpringBootApplication
public class RbCaisseApplication {
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder encoder;
    Environment env;

    public static void main(String[] args) {
        SpringApplication.run(RbCaisseApplication.class, args);
    }


    @Component
    public class MyCommandLineRunner implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            /*        *************Création des Roles*************/
            if(!roleRepository.findByName("admin").isPresent()) {
                Role roleAdmin = new Role();
                Role roleConsulteur = new Role();
                Role roleAcheteur = new Role();
                roleAdmin.setName("admin");
                roleConsulteur.setName("consulteur");
                roleAcheteur.setName("acheteur");
                roleRepository.save(roleAdmin);
                roleRepository.save(roleConsulteur);
                roleRepository.save(roleAcheteur);
            }
            /*		***************************************
             *************Création User**************/
            if(!userRepository.existsByUsername("a.yahya")){


                Role roleAdminUser=roleRepository.findByName("admin").get();
                List<Role> listeRole=new ArrayList<>();
                listeRole.add(roleAdminUser);
                User user=new User();
                user.setUsername("a.yahya");
                user.setPassword(encoder.encode("vonberuf"));
                user.setNom("ahroum");
                user.setPrenom("yahya");
                user.setSession("Actif");
                user.setMatricule("44896");
                user.setRoles(listeRole);
                userRepository.save(user);
            }
        }
    }
}
