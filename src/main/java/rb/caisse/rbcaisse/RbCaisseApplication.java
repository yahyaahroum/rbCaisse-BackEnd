package rb.caisse.rbcaisse;


import lombok.AllArgsConstructor;
import rb.caisse.rbcaisse.config.GlobalVariableConfig;

import rb.caisse.rbcaisse.entity.*;
import rb.caisse.rbcaisse.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import rb.caisse.rbcaisse.security.SecurityAuditorAware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@EnableConfigurationProperties(GlobalVariableConfig.class)
@SpringBootApplication
public class RbCaisseApplication {
    UserRepository userRepository;
    RoleRepository roleRepository;
    NatureOperationRepository natureOperationRepository;
    ModeOperationRepository modeOperationRepository;
    CompteComptableRepository compteComptableRepository;
    NatureAlimentationRepository natureAlimentationRepository;
    PasswordEncoder encoder;
    GlobalVariableConfig globalVariableConfig;

    public static void main(String[] args) {
        SpringApplication.run(RbCaisseApplication.class, args);
    }
	@Bean
	public AuditorAware<String> auditorAware() {
		return new SecurityAuditorAware(globalVariableConfig);
	}

    @Component
    public class MyCommandLineRunner implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            /*        *************Création des Roles*************/
            if(!roleRepository.findByName("admin").isPresent()) {
                Role roleAdmin = new Role();
                Role roleConsulteur = new Role();
                Role roleComptable = new Role();
                Role roleCaissier = new Role();
                roleAdmin.setName("admin");
                roleConsulteur.setName("consulteur");
                roleComptable.setName("comptable");
                roleComptable.setName("caissier");
                roleRepository.save(roleAdmin);
                roleRepository.save(roleConsulteur);
                roleRepository.save(roleComptable);
                roleRepository.save(roleCaissier);
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
                user.setEmail("a.yahya@richebois.ma");
                user.setSession("Actif");
                user.setMatricule("44896");
                user.setRoles(listeRole);
                userRepository.save(user);
            }
           if(!compteComptableRepository.existsByCodeComptable("61431000")){
                CompteComptable compte=new CompteComptable();
                compte.setCodeComptable("61431000");
                compte.setIntitule("Voyages et déplacements");
                compteComptableRepository.save(compte);
                compte=new CompteComptable();
                compte.setCodeComptable("61331000");
                compte.setIntitule("Entretien et réparations des biens immobiliers");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("61225000");
                compte.setIntitule("Achats de fournitures d'atelier et d'usine");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("61436000");
                compte.setIntitule("Réceptions");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("61227000");
                compte.setIntitule("Achats de fournitures de bureau");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("61251000");
                compte.setIntitule("Achats de fournitures non stockables (eau, électricité,)");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("44320000");
                compte.setIntitule("Rémunérations dues au personnel");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("61766000");
                compte.setIntitule("Médecine de travail, pharmacie");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("61420000");
                compte.setIntitule("Transports");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("61313000");
                compte.setIntitule("Locations de matériel et d'outillage");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("61318000");
                compte.setIntitule("Locations et charges locatives diverses");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("61224000");
                compte.setIntitule("Achats de produits d'entretien");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("61351000");
                compte.setIntitule("Rémunérations du personnel occasionnel");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("61210000");
                compte.setIntitule("Achats de matières premières");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("34310000");
                compte.setIntitule("Avances et acomptes au personnel");
                compteComptableRepository.save(compte);
               compte=new CompteComptable();
                compte.setCodeComptable("24110000");
                compte.setIntitule("Prêts immobilsés");
                compteComptableRepository.save(compte);
                compte=new CompteComptable();
                compte.setCodeComptable("51610000");
                compte.setIntitule("Caisses");
                compteComptableRepository.save(compte);
            }
            if(!natureOperationRepository.existsByLibelle("DEPLACEMENT")){
               CompteComptable compte=new CompteComptable();
                NatureOperation nature=new NatureOperation();

                compte=compteComptableRepository.
                        findAllByCodeComptable("61431000");
                nature.setCompteComptable(compte);
                nature.setLibelle("DEPLACEMENT");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61331000");
                nature.setCompteComptable(compte);
                nature.setLibelle("REPARATION MATERIEL");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61225000");
                nature.setCompteComptable(compte);
                nature.setLibelle("FOURNITURE DE CHANTIER");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61436000");
                nature.setCompteComptable(compte);
                nature.setLibelle("MISSION ET RECEPTION");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61227000");
                nature.setCompteComptable(compte);
                nature.setLibelle("FOURNITURE BUREAU");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61251000");
                nature.setCompteComptable(compte);
                nature.setLibelle("GASOIL");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("44320000");
                nature.setCompteComptable(compte);
                nature.setLibelle("S.T.C");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61766000");
                nature.setCompteComptable(compte);
                nature.setLibelle("AT");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61420000");
                nature.setCompteComptable(compte);
                nature.setLibelle("TRANSPORT");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61313000");
                nature.setCompteComptable(compte);
                nature.setLibelle("LOCATION MATERIEL");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61318000");
                nature.setCompteComptable(compte);
                nature.setLibelle("LOCATION APPARETEMENT");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61766000");
                nature.setCompteComptable(compte);
                nature.setLibelle("MEDICAMENT");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61431000");
                nature.setCompteComptable(compte);
                nature.setLibelle("GARDIEN");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61224000");
                nature.setCompteComptable(compte);
                nature.setLibelle("PRODUITS DE NETTOYAGE");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61251000");
                nature.setCompteComptable(compte);
                nature.setLibelle("EAU ET ELCTRICITE");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61351000");
                nature.setCompteComptable(compte);
                nature.setLibelle("SOUS-TRAITANT");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("61210000");
                nature.setCompteComptable(compte);
                nature.setLibelle("CHARGES DIVERS");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("34310000");
                nature.setCompteComptable(compte);
                nature.setLibelle("AVANCE SUR SALAIRE");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("34310000");
                nature.setCompteComptable(compte);
                nature.setLibelle("AVANCE SUR CONGE");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("24110000");
                nature.setCompteComptable(compte);
                nature.setLibelle("PRÊT");
                natureOperationRepository.save(nature);
                compte=new CompteComptable();
                nature=new NatureOperation();
                compte=compteComptableRepository.
                        findAllByCodeComptable("51610000");
                nature.setCompteComptable(compte);
                nature.setLibelle("ALIMENTATION CAISSE");
                natureOperationRepository.save(nature);
            }
            if(!modeOperationRepository.existsByLibelle("MISE A DISPOSITION")){
                List<String> listeMode= Arrays.asList("MISE A DISPOSITION","FACTURE","NOTE DE FRAIS","ATTACHEMENT","BON","NON JUSTIFIER");
                listeMode.forEach(m->{
                    ModeOperation mode=new ModeOperation();
                    mode.setLibelle(m);
                    modeOperationRepository.save(mode);
                        });
            }
            if(!natureAlimentationRepository.existsByLibelle("CAISSE")) {
                List<String> listeNatures = Arrays.asList("CAISSE", "LOYER", "FRAIS GENEREAUX", "SOUS-TRAITANT", "REMENURATION DU PERESONNEL OCCASIONNEL", "DEBLAIS", "AVANCE SUR SALAIRE");
                listeNatures.forEach(m -> {
                    NatureAlimentation nature = new NatureAlimentation();
                    nature.setLibelle(m);
                    natureAlimentationRepository.save(nature);
                });
            }
        }
    }
}
