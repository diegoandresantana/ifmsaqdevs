package br.com.timao.config.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.timao.entity.Usuario;

public interface InterUsuarioDAO extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
