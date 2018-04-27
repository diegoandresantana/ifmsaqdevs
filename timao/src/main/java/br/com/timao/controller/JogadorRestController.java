package br.com.timao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.timao.dao.InterJogadorDAO;
import br.com.timao.entity.Jogador;

  
@RestController
public class JogadorRestController {

	@Autowired
	private InterJogadorDAO interJogadorDAO;
	 
	@RequestMapping(value="/jogadorrest/lista",method = RequestMethod.GET)
	public  List<Jogador>  getListaJogador() {
		return (List<Jogador>) interJogadorDAO.findAll();
	}
		
	@RequestMapping(value="/jogadorrest/salvar",
			method = RequestMethod.POST)
	public  String salvar(Jogador j) {
		Jogador jog=interJogadorDAO.save(j);
		if(jog!=null) {			
			return "ok";
		}else {
			return "erro";
		}
	}	 
	
	@RequestMapping(value="/jogadorrest/buscarporid",
			method = RequestMethod.POST)
	public  Jogador buscarPorId(@Param("idJogador") Integer id) {
		Jogador j=interJogadorDAO.findOne(id);
		return j;
	}
	
}