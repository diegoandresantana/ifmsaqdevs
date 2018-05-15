package br.com.timao.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.timao.dao.DAOGeneric;
import br.com.timao.dao.InterCidadeDAO;
import br.com.timao.entity.Cidade;

  
@RestController
public class CidadeRestController {
	 
	@Autowired
	private InterCidadeDAO interCidadeDAO;
	 
	@RequestMapping(value="/cidaderest/lista",method = RequestMethod.GET)
	public  List<Cidade>  getListaCidade() {
		List  <Cidade> lista=(List<Cidade>)interCidadeDAO.findAll().stream()                
                .collect(Collectors.toList());
		
		return  lista;
	}
		
	@RequestMapping(value="/cidaderest/salvar",method = RequestMethod.POST)
	public  String salvar(Cidade j) {
		Cidade jog=interCidadeDAO.save(j);
		if(jog!=null) {			
			return "ok";
		}else {
			return "erro";
		}
	}	 	
	@RequestMapping(value="/cidaderest/buscarporid",method = RequestMethod.POST)
	public  Cidade buscarPorId(@RequestParam("idCidade") Integer id) {
		Cidade j=interCidadeDAO.findOne(id);
		return j;
	}
	
	@RequestMapping(value="/cidaderest/deletar",method = RequestMethod.POST)
	public  String deletar(@RequestParam("idCidade") Integer id) {
		 interCidadeDAO.delete(id); 
		 Cidade j=interCidadeDAO.findOne(id);
		 if(j==null) {
			 return "ok";
		 }else {
			 return "erro";
		 }
		 
	}
	
}