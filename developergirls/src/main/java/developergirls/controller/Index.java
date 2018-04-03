package developergirls.controller;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import developergirls.dao.inter.CategoriaInterDAO;
import developergirls.entity.Categoria;

@RestController
public class Index {
	
	@Autowired
	private CategoriaInterDAO categoriaInterDAO;
		 
	@RequestMapping(value="/index/categorias",method = RequestMethod.GET)
	public  Categoria  getCategoria() {
		return (Categoria) categoriaInterDAO.findAll(new Sort(Sort.Direction.ASC, "nomeCategoria")) ;
	}
	
	
	 
}
