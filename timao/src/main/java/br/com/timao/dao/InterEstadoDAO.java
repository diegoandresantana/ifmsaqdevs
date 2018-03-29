package br.com.timao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.timao.entity.Estado;

public interface InterEstadoDAO  extends JpaRepository<Estado, Integer>{

}
