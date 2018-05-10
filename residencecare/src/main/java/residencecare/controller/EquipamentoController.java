package residencecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import residencecare.dao.inter.ChuvaInterDAO;
import residencecare.dao.inter.ControleEstadoInterDAO;
import residencecare.dao.inter.LuminosidadeInterDAO;
import residencecare.dao.inter.TemperaturaInterDAO;
import residencecare.dao.inter.UmidadeInterDAO;
import residencecare.entity.Chuva;
import residencecare.entity.ControleEstado;
import residencecare.entity.Umidade;

@RestController
public class EquipamentoController {
	@Autowired
	private ChuvaInterDAO chuvaInterDAO;
	@Autowired
	private TemperaturaInterDAO temperaturaInterDAO;
	@Autowired
	private UmidadeInterDAO umidadeInterDAO;
	@Autowired
	private LuminosidadeInterDAO luminosidadeInterDAO;
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
				 c.setPorta2(valor);
				 controleEstadoInterDAO.save(c);
				 break;
			 case 3:
				 c.setPorta3(valor);
				 controleEstadoInterDAO.save(c);
				 break;
			 case 4:
				 c.setPorta4(valor);
				 controleEstadoInterDAO.save(c);
				 break;
			 case 5:
				 c.setPorta5(valor);
				 controleEstadoInterDAO.save(c);
				 break;
			 case 6:
				 c.setPorta6(valor);
				 controleEstadoInterDAO.save(c);
				 break;
			 case 7:
				 c.setPorta7(valor);
				 controleEstadoInterDAO.save(c);
				 break;
			 case 8:
				 c.setPorta8(valor);
				 controleEstadoInterDAO.save(c);
				 break;
		 }
		 
		 return "ok";
	}
	
	@RequestMapping(value="/equipamento/alerta",method = RequestMethod.GET)
	public  boolean  getAlerta() {
		ControleEstado cE=controleEstadoInterDAO.findOne(1);
		if(!cE.isPrevencaoAtiva()){
			return false;
		}
		if(!cE.isPorta1() && !cE.isPorta2() && !cE.isPorta3() && !cE.isPorta4()
		  && !cE.isPorta5() && !cE.isPorta6() && !cE.isPorta7() && !cE.isPorta8()) {
			return false;
		}
		Umidade u = umidadeInterDAO.lastItem();
	    Chuva c=chuvaInterDAO.lastItem();
		if((c.getDado()>70 && u.getDado()>90) ||  c.getDado()>=91) {
			return true;
		}else {
			return false ;
		}
	
	}
	@RequestMapping(value="/equipamento/desativarprevencao",method = RequestMethod.GET)
	public  void desativarPrevencao(){
		ControleEstado c=controleEstadoInterDAO.findOne(1);
		c.setPrevencaoAtiva(false);
		controleEstadoInterDAO.save(c);
	}
	@RequestMapping(value="/equipamento/ativarprevencao",method = RequestMethod.GET)
	public  void ativarPrevencao(){
		ControleEstado c=controleEstadoInterDAO.findOne(1);
		c.setPrevencaoAtiva(true);
		controleEstadoInterDAO.save(c);
	}
	@RequestMapping(value="/equipamento/desligar",method = RequestMethod.GET)
	public  void desligar() {
		ControleEstado c=controleEstadoInterDAO.findOne(1);
		c.setPorta1(true);
		c.setPorta2(true);
		c.setPorta3(true);
		c.setPorta4(true);
		c.setPorta5(true);
		c.setPorta6(true);
		c.setPorta7(true);
		c.setPorta8(true);
		controleEstadoInterDAO.save(c);
	}
	 
	 
}
