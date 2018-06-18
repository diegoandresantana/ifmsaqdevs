package residencecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
public class HistoricoController  extends BasicSecurityRestController{
	
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
		return (List<Temperatura>) temperaturaInterDAO.findAll(new Sort(Direction.DESC, "dataHora"));
	}
	@RequestMapping(value="/historico/historicoChuva",method = RequestMethod.GET)
	public  List<Chuva>  getChuvaLista() {
		return (List<Chuva>) chuvaInterDAO.findAll(new Sort(Direction.DESC, "dataHora"));
				 
	}
	
	@RequestMapping(value="/historico/historicoUmidade",method = RequestMethod.GET)
	public  List<Umidade>  getUmidadeLista() {
		return (List<Umidade>) umidadeInterDAO.findAll(new Sort(Direction.DESC, "dataHora"));
	}
	
	@RequestMapping(value="/historico/historicoLuminosidade",method = RequestMethod.GET)
	public  List<Luminosidade>  getLuminosidadeLista() {
		return (List<Luminosidade>) luminosidadeInterDAO.findAll(new Sort(Direction.DESC, "dataHora"));
	}
	 
	 
}
