package br.com.timao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.timao.entity.Cidade;

public interface InterCidadeDAO  extends JpaRepository<Cidade, Integer>{

}
