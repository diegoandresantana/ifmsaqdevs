package br.com.timao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.timao.dao.InterJogadorDAO;
import br.com.timao.entity.Jogador;
@EnableAutoConfiguration
@Controller
public class JogadorController {

	@Autowired
	private InterJogadorDAO interJogadorDAO;
	 
	@PostMapping("/jogadores")
	public String salvar(Jogador jogador) {
		this.interJogadorDAO.save(jogador);
		
		return "redirect:/jogadores";
	}	
	
	@GetMapping("/jogadores")
	public ModelAndView listar() { 
		ModelAndView modelAndView = new ModelAndView("Jogador");
		
		modelAndView.addObject("jogadores", interJogadorDAO.findAll());
		modelAndView.addObject("jogador", new Jogador());
		
		return modelAndView;
	}
	public String deletar(@PathVariable(value = "id")Integer id) {
		System.out.println(id);
		return "redirect:/jogadores";
	}
	 
}