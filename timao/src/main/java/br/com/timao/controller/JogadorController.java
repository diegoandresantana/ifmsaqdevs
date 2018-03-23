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

import br.com.timao.dao.InterJogadorDAO;
import br.com.timao.entity.Jogador;

 
@EnableAutoConfiguration
@Controller
public class JogadorController {

	@Autowired
	private InterJogadorDAO interJogadorDAO;
	@GetMapping("/jogador")
	public ModelAndView construir(Model model,
			@ModelAttribute("jogador") Jogador j) {
		    ModelAndView modelAndView = new ModelAndView("Jogador");
			modelAndView.addObject("listaJogador", interJogadorDAO.findAll());
			modelAndView.addObject("jogador", 
					(j!=null && j.getNome()!=null)?j:new Jogador());
			
			return modelAndView;		 
	}
	@PostMapping("/jogador/salvar")
	public String salvar(Jogador jogador,
			final RedirectAttributes redirectAttributes) {
		 
		if(this.interJogadorDAO.save(jogador)!=null) {
			redirectAttributes.addFlashAttribute("salvo", "ok");			
		}else {
			redirectAttributes.addFlashAttribute("salvo", "erro");
		}
		
		return "redirect:/jogador";
	}		
	 
	@GetMapping("/jogador/deletar")
	public String deletar(@ModelAttribute("id") Integer id,
			final RedirectAttributes redirectAttributes) {
		this.interJogadorDAO.delete(id);
		Jogador j= this.interJogadorDAO.findOne(id);
		if(j==null || 
				j.getIdJogador()==null ) {
			redirectAttributes.addFlashAttribute("deletar", "ok");	
		}else {
			redirectAttributes.addFlashAttribute("deletar", "erro");				
		}		 
		return "redirect:/jogador";
	}
	@GetMapping("/jogador/editar")
	public ModelAndView recuperaObjeto(
			@ModelAttribute("id") Integer id,Model model) {
		Jogador j=this.interJogadorDAO.findOne(id);
		return construir(model, j); 
	}
		
		 
	
}