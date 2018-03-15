package br.com.timao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.timao.entity.Jogador;

public interface InterJogadorDAO  extends JpaRepository<Jogador, Integer>{

}
