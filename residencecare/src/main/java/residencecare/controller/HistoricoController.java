package residencecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import residencecare.dao.inter.ChuvaInterDAO;
import residencecare.dao.inter.LuminosidadeInterDAO;
import residencecare.dao.inter.TemperaturaInterDAO;
import residencecare.dao.inter.UmidadeInterDAO;
import residencecare.entity.Chuva;
import residencecare.entity.Luminosidade;
import residencecare.entity.Temperatura;
import residencecare.entity.Umidade;

@RestController
public class HistoricoController {
	
	@Autowired
	private ChuvaInterDAO chuvaInterDAO;
	@Autowired
	private TemperaturaInterDAO temperaturaInterDAO;
	@Autowired
	private UmidadeInterDAO umidadeInterDAO;
	@Autowired
	private LuminosidadeInterDAO luminosidadeInterDAO;
		 
	@RequestMapping(value="/historico/historicoTemperatura",method = RequestMethod.GET)
	public  List<Temperatura>  getTemperaturaLista() {
		return (List<Temperatura>) temperaturaInterDAO.findAll();
	}
	
	@RequestMapping(value="/historico/historicochuva",method = RequestMethod.GET)
	public  Chuva  getChuvaAtual() {
		return (Chuva) chuvaInterDAO.lastItem();
	}
	
	@RequestMapping(value="/historico/umidade",method = RequestMethod.GET)
	public  Umidade getUmidadeAtual() {
		return (Umidade) umidadeInterDAO.lastItem();
	}
	
	@RequestMapping(value="/historico/luminosidadeAtual",method = RequestMethod.GET)
	public  Luminosidade  getLuminosidadeAtual() {
		return (Luminosidade) luminosidadeInterDAO.lastItem();
	}
	 
}
