package developergirls.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import developergirls.dao.inter.CategoriaInterDAO;
import developergirls.dao.inter.MensagemInterDAO;
import developergirls.dao.inter.NoticiaInterDAO;
import developergirls.dao.inter.UsuarioInterDAO;
import developergirls.entity.Categoria;
import developergirls.entity.Mensagem;
import developergirls.entity.Noticia;
import developergirls.entity.Usuario;

@RestController
public class Index {
	
	@Autowired
	private CategoriaInterDAO categoriaInterDAO;
	@Autowired
	private MensagemInterDAO mensagemInterDAO;
	@Autowired
	private NoticiaInterDAO noticiaInterDAO;
	@Autowired
	private UsuarioInterDAO usuarioInterDAO;
		 
	@RequestMapping(value="/index/categorias",method = RequestMethod.GET)
	public  Categoria  getCategoria() {
		return (Categoria) categoriaInterDAO.findAll(new Sort(Sort.Direction.ASC, "nomeCategoria")) ;
	}
	@RequestMapping(value="/index/ultimasnoticias",method = RequestMethod.GET)
	public  Categoria  getUltimaNoticia() {
		return (Categoria) categoriaInterDAO.findAll(new Sort(Sort.Direction.DESC, "dataPublicacao")) ;
	}
	@RequestMapping(value="/index/mensagem/salvar",method = RequestMethod.POST)
	public  String  salvarMensagem(Mensagem m) {
		 
		Mensagem ms=mensagemInterDAO.save(m);
		
		if(ms!=null && ms.getIdMensagem()!=null) {
			return "Mensagem enviada!";
		}
		return "Mensagem não foi enviada!";
	}
	@RequestMapping(value="/index/logar",method = RequestMethod.POST)
	public  String  logar(@Param("login") String login, @Param("senha")  String senha) {
		if(login!=null) {
			Usuario u=usuarioInterDAO.getByLogin(login);
			System.out.println(u.getLogin());
		}
		return  "";
	}
	
	@RequestMapping(value="/index/noticia/noticiasporcategoria",method = RequestMethod.GET)
	public  List<Noticia>  getNoticiaPorCategoria(@Param("categoria") String categoria) {
		return  noticiaInterDAO.findAll(new Sort(Sort.Direction.DESC, "dataPublicacao")) ;
	}
	
	 
}
