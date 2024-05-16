package rb.caisse.rbcaisse.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rb.caisse.rbcaisse.entity.Affaire;


import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String username;
  private String email;
  private String nom;
  private String prenom;
  private List<Affaire> affaire;
  private String session;
  private List<String> roles;

  public JwtResponse(String accessToken, Long id, String username, String email,String nom,String prenom,List<Affaire> affaire,String session, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.email = email;
    this.nom=nom;
    this.prenom=prenom;
    this.affaire=affaire;
    this.session=session;
    this.roles = roles;
  }
}
