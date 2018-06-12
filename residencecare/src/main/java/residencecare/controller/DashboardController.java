package residencecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import residencecare.config.security.controller.BasicSecurityRestController;
import residencecare.dao.inter.ChuvaInterDAO;
import residencecare.dao.inter.LuminosidadeInterDAO;
import residencecare.dao.inter.TemperaturaInterDAO;
import residencecare.dao.inter.UmidadeInterDAO;
import residencecare.entity.Chuva;
import residencecare.entity.Luminosidade;
import residencecare.entity.Temperatura;
import residencecare.entity.Umidade;

@RestController
public class DashboardController  extends BasicSecurityRestController{
	
	
	@Autowired
	private ChuvaInterDAO chuvaInterDAO;
	@Autowired
	private TemperaturaInterDAO temperaturaInterDAO;
	@Autowired
	private UmidadeInterDAO umidadeInterDAO;
	@Autowired
	private LuminosidadeInterDAO luminosidadeInterDAO;
		 
	@RequestMapping(value="/dashboard/temperaturaAtual",method = RequestMethod.GET)
	public  Temperatura  getTemperaturaAtual() {
		return (Temperatura) temperaturaInterDAO.lastItem();
	}
	
	@RequestMapping(value="/dashboard/chuvaAtual",method = RequestMethod.GET)
	public  Chuva  getChuvaAtual() {
		return (Chuva) chuvaInterDAO.lastItem();
	}
	
	@RequestMapping(value="/dashboard/umidadeAtual",method = RequestMethod.GET)
	public  Umidade getUmidadeAtual() {
		return (Umidade) umidadeInterDAO.lastItem();
	}
	
	@RequestMapping(value="/dashboard/luminosidadeAtual",method = RequestMethod.GET)
	public  Luminosidade  getLuminosidadeAtual() {
		return (Luminosidade) luminosidadeInterDAO.lastItem();
	}
	 
}
