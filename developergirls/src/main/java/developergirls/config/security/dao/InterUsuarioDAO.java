package developergirls.config.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import developergirls.entity.Usuario;

public interface InterUsuarioDAO extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
