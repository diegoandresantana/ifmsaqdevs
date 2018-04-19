package residencecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		return (ControleEstado) controleEstadoInterDAO.findOne(1);
	}
	@RequestMapping(value="/equipamento/alterarRele",method = RequestMethod.POST)
	public  String   getAlterarRele(@Param("idControleEstado") Integer idControleEstado,@Param("valor") boolean valor,
			@Param("numeroRele") Integer numeroRele) {
		 ControleEstado c=controleEstadoInterDAO.findOne(1);
		 switch(numeroRele) {
			 case 1:
				 c.setPorta1(valor);
				 controleEstadoInterDAO.save(c);
				 break;		 
			 case 2:
				 break;
		 }
		 
		 return "ok";
	}
 
	
	 
}
