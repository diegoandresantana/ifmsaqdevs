package residencecare.config.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import residencecare.entity.Usuario;

public interface InterUsuarioDAO extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
