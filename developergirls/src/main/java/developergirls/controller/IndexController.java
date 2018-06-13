package developergirls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import developergirls.dao.inter.InterCategoriaDAO;
import developergirls.dao.inter.InterMensagemDAO;
import developergirls.dao.inter.InterNoticiaDAO;
import developergirls.entity.Categoria;
import developergirls.entity.Mensagem;
import developergirls.entity.Noticia;

@RestController
public class IndexController {
	
	@Autowired
	private InterCategoriaDAO interCategoriaDAO;
	@Autowired
	private InterMensagemDAO interMensagemDAO;
	@Autowired
	private InterNoticiaDAO interNoticiaDAO;
	 
		 
	@RequestMapping(value="/index/categorias",method = RequestMethod.GET)
	public  Categoria  getCategoria() {
		return (Categoria) interCategoriaDAO.findAll(new Sort(Sort.Direction.ASC, "nomeCategoria")) ;
	}
	@RequestMapping(value="/index/ultimasnoticias",method = RequestMethod.GET)
	public  Categoria  getUltimaNoticia() {
		return (Categoria) interCategoriaDAO.findAll(new Sort(Sort.Direction.DESC, "dataPublicacao")) ;
	}
	@RequestMapping(value="/index/mensagem/salvar",method = RequestMethod.POST)
	public  String  salvarMensagem(Mensagem m) {
		 
		Mensagem ms=interMensagemDAO.save(m);
		
		if(ms!=null && ms.getIdMensagem()!=null) {
			return "Mensagem enviada!";
		}
		return "Mensagem não foi enviada!";
	}
	 
	
	@RequestMapping(value="/index/noticia/noticiasporcategoria",method = RequestMethod.GET)
	public  List<Noticia>  getNoticiaPorCategoria(@Param("categoria") String categoria) {
		return  interNoticiaDAO.findAll(new Sort(Sort.Direction.DESC, "dataPublicacao")) ;
	}
	
	 
}
