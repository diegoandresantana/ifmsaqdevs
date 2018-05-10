package br.com.timao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.timao.dao.InterEstadoDAO;
import br.com.timao.entity.Estado;

  
@RestController
public class EstadoRestController {

	@Autowired
	private InterEstadoDAO interEstadoDAO;
	 
	@RequestMapping(value="/estadorest/lista",method = RequestMethod.GET)
	public  List<Estado>  getListaEstado() {
		return (List<Estado>) interEstadoDAO.findAll();
	}
		
	@RequestMapping(value="/estadorest/salvar",method = RequestMethod.POST)
	public  String salvar(Estado j) {
		Estado jog=interEstadoDAO.save(j);
		if(jog!=null) {			
			return "ok";
		}else {
			return "erro";
		}
	}	 	
	@RequestMapping(value="/estadorest/buscarporid",method = RequestMethod.POST)
	public  Estado buscarPorId(@RequestParam("idEstado") Integer id) {
		Estado j=interEstadoDAO.findOne(id);
		return j;
	}
	
	@RequestMapping(value="/estadorest/deletar",method = RequestMethod.POST)
	public  String deletar(@RequestParam("idEstado") Integer id) {
		 interEstadoDAO.delete(id); 
		 Estado j=interEstadoDAO.findOne(id);
		 if(j==null) {
			 return "ok";
		 }else {
			 return "erro";
		 }
		 
	}
	
}