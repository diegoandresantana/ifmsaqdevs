package residencecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import residencecare.dao.inter.ControleEstadoInterDAO;
import residencecare.entity.ControleEstado;

@RestController
public class EquipamentoController {
	
	@Autowired
	private ControleEstadoInterDAO controleEstadoInterDAO;
	 
	@RequestMapping(value="/equipamento/status",method = RequestMethod.GET)
	public  ControleEstado  getTemperaturaAtual() {
		return (ControleEstado) controleEstadoInterDAO.getOne(1);
	}
	
	
	 
}
