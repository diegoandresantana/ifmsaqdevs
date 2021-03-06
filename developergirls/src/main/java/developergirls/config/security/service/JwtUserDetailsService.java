package developergirls.config.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import developergirls.config.security.JwtUserFactory;
import developergirls.config.security.dao.InterUsuarioDAO;
import developergirls.entity.Usuario;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private InterUsuarioDAO userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
