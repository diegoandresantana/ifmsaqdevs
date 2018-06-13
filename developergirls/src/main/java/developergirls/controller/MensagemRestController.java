package developergirls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import developergirls.config.security.controller.BasicSecurityRestController;
import developergirls.dao.inter.InterMensagemDAO;
import developergirls.entity.Mensagem;

@EnableAutoConfiguration
@RestController
public class MensagemRestController extends BasicSecurityRestController{

	@Autowired
	private InterMensagemDAO interMensagemDAO;
	 
	@RequestMapping(value="/mensagemrest/lista",method = RequestMethod.GET)
	public  List<Mensagem>  getListaMensagem() {
		return (List<Mensagem>) interMensagemDAO.findAll();
	}
		
	@RequestMapping(value="/mensagemrest/salvar",method = RequestMethod.POST)
	public  String salvar(Mensagem j) {
		Mensagem jog=interMensagemDAO.save(j);
		if(jog!=null) {			
			return "ok";
		}else {
			return "erro";
		}
	}	 	
	@RequestMapping(value="/mensagemrest/buscarporid",method = RequestMethod.POST)
	public  Mensagem buscarPorId(@RequestParam("idMensagem") Long id) {
		Mensagem j=interMensagemDAO.findOne(id);
		return j;
	}
	 
	@RequestMapping(value="/mensagemrest/deletar",method = RequestMethod.POST)
	public  String deletar(@RequestParam("idMensagem") Long id) {
		 interMensagemDAO.delete(id); 
		 Mensagem j=interMensagemDAO.findOne(id);
		 if(j==null) {
			 return "ok";
		 }else {
			 return "erro";
		 }
		 
	}
	
}