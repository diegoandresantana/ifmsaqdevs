package br.com.timao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
	@RequestMapping(value="/jogadorrest/salvar",method = RequestMethod.POST)
	public  String salvar(Jogador j) {
		Jogador jog=interJogadorDAO.save(j);
		if(jog!=null) {			
			return "ok";
		}else {
			return "erro";
		}
	}	 	
	@RequestMapping(value="/jogadorrest/buscarporid",method = RequestMethod.POST)
	public  Jogador buscarPorId(@RequestParam("idJogador") Integer id) {
		Jogador j=interJogadorDAO.findOne(id);
		return j;
	}
	
	@RequestMapping(value="/jogadorrest/deletar",method = RequestMethod.POST)
	public  String deletar(@RequestParam("idJogador") Integer id) {
		 interJogadorDAO.delete(id); 
		 Jogador j=interJogadorDAO.findOne(id);
		 if(j==null) {
			 return "ok";
		 }else {
			 return "erro";
		 }
		 
	}
	
}