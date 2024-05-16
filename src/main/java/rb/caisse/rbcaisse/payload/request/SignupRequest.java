package rb.caisse.rbcaisse.payload.request;

import java.util.List;

import jakarta.validation.constraints.*;
import lombok.Data;
import rb.caisse.rbcaisse.entity.Affaire;


@Data

public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private List<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  @NotBlank
  @Size(min = 1, max = 20)
  private String nom;

  @NotBlank
  @Size(min = 1, max = 20)
  private String prenom;

  @NotBlank
  @Size(min = 1, max = 10)
  private String session;

  @NotBlank
  @Size(min = 1, max = 10)
  private String sexe;

  @NotBlank
  @Size(min = 1, max = 10)
  private String matricule;

  private List<Affaire> affaires;



  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getRole() {
    return role;
  }

  public void setRole(List<String> role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getSession() {
    return session;
  }

  public void setSession(String session) {
    this.session = session;
  }

  public String getSexe() {
    return sexe;
  }

  public void setSexe(String sexe) {
    this.sexe = sexe;
  }

  public String getMatricule() {
    return matricule;
  }

  public void setMatricule(String matricule) {
    this.matricule = matricule;
  }

  public List<Affaire> getAffaires() {
    return affaires;
  }

  public void setAffaires(List<Affaire> affaires) {
    this.affaires = affaires;
  }

  public SignupRequest(String username, String email, List<String> role, String password, String nom, String prenom, String session, String sexe, String matricule, List<Affaire> affaires) {
    this.username = username;
    this.email = email;
    this.role = role;
    this.password = password;
    this.nom = nom;
    this.prenom = prenom;
    this.session = session;
    this.sexe = sexe;
    this.matricule = matricule;
    this.affaires = affaires;
  }
}
