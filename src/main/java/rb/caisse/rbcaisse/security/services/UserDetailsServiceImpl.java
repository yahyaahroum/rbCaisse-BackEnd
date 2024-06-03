package rb.caisse.rbcaisse.security.services;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import rb.caisse.rbcaisse.config.GlobalVariableConfig;
import rb.caisse.rbcaisse.entity.User;
import rb.caisse.rbcaisse.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	GlobalVariableConfig globalVariableConfig;
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        globalVariableConfig.userConnected=user;
    return UserDetailsImpl.build(user);
  }

}
