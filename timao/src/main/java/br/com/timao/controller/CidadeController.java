package br.com.timao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.timao.dao.InterCidadeDAO;
import br.com.timao.dao.InterEstadoDAO;
import br.com.timao.entity.Cidade;
import br.com.timao.entity.Estado;

 
@EnableAutoConfiguration
@Controller
public class CidadeController {

	@Autowired
	private InterCidadeDAO interCidadeDAO;
	@Autowired
	private InterEstadoDAO interEstadoDAO;
	@GetMapping("/cidade")
	public ModelAndView construir(Model model,
			@ModelAttribute("cidade") Cidade j) {
		    ModelAndView modelAndView = new ModelAndView("Cidade");
			modelAndView.addObject("listaCidade", interCidadeDAO.findAll());
			modelAndView.addObject("comboEstado", interEstadoDAO.findAll());
			modelAndView.addObject("cidade", 
					(j!=null && j.getNomeCidade()!=null)
					?j:new Cidade()); 
			interEstadoDAO.save( new Estado(1,"Mato Grosso","MS"));
			return modelAndView;		 
	}
	@PostMapping("/cidade/salvar")
	public String salvar(Cidade cidade,
			final RedirectAttributes redirectAttributes) {
		 
		if(this.interCidadeDAO.save(cidade)!=null) {
			redirectAttributes.addFlashAttribute("salvo", "ok");			
		}else {
			redirectAttributes.addFlashAttribute("salvo", "erro");
		}
		
		return "redirect:/cidade";
	}		
	 
	@GetMapping("/cidade/deletar")
	public String deletar(@ModelAttribute("id") Integer id,
			final RedirectAttributes redirectAttributes) {
		this.interCidadeDAO.delete(id);
		Cidade j= this.interCidadeDAO.findOne(id);
		if(j==null || 
				j.getIdCidade()==null ) {
			redirectAttributes.addFlashAttribute("deletar", "ok");	
		}else {
			redirectAttributes.addFlashAttribute("deletar", "erro");				
		}		 
		return "redirect:/cidade";
	}
	@GetMapping("/cidade/editar")
	public ModelAndView recuperaObjeto(
			@ModelAttribute("id") Integer id,Model model) {
		Cidade j=this.interCidadeDAO.findOne(id);
		return construir(model, j); 
	}
		
		 
	
}