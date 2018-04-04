package webgeneros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import webgeneros.dao.MensagemInterDAO;
import webgeneros.dao.UsuarioInterDAO;
import webgeneros.entity.Mensagem;
import webgeneros.entity.Usuario;

@RestController
public class Index {
	
	@Autowired
	private MensagemInterDAO mensagemInterDAO;
	@Autowired
	private UsuarioInterDAO usuarioInterDAO;
		 
	 
	@RequestMapping(value="/index/mensagem/salvar",method = RequestMethod.POST)
	public  String  salvarMensagem(Mensagem m) {
		 
		Mensagem ms=mensagemInterDAO.save(m);
		
		if(ms!=null && ms.getIdMensagem()!=null) {
			return "Mensagem enviada!";
		}
		return "Mensagem não foi enviada!";
	}
	@RequestMapping(value="/index/mensagem/listar",method = RequestMethod.GET)
	public  List<Mensagem>  listarMensagem() {
		 
	 return mensagemInterDAO.findAll();
		 
	}
	@RequestMapping(value="/index/logar",method = RequestMethod.POST)
	public  String  logar(@Param("login") String login, @Param("senha")  String senha) {
		if(login!=null) {
			Usuario u=usuarioInterDAO.getByLogin(login);
			System.out.println(u.getLogin());
		}
		return  "";
	}
	
 
}
