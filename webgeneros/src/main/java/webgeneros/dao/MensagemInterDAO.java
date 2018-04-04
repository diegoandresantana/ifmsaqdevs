package webgeneros.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import webgeneros.entity.Mensagem;

public interface MensagemInterDAO extends JpaRepository<Mensagem, Long> {

}
