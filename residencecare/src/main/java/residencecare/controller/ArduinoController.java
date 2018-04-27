package residencecare.controller;

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
public class ArduinoController {
	
	@Autowired
	private ChuvaInterDAO chuvaInterDAO;
	@Autowired
	private UmidadeInterDAO umidadeInterDAO;
	@Autowired
	private TemperaturaInterDAO temperaturaInterDAO;
	@Autowired
	private LuminosidadeInterDAO luminosidadeInterDAO;
			 
	@RequestMapping(value="/arduino/salvarchuva",method = RequestMethod.GET)
	public  String salvarChuva(Chuva c) {
		Chuva o=chuvaInterDAO.save(c);
		if(o.getIdChuva()!=null) {
			return "ok";
		}else{
			return "erro";
		}		 
	}
		 
	@RequestMapping(value="/arduino/salvarumidade",method = RequestMethod.GET)
	public  String salvarUmidade(Umidade u) {
		Umidade o=umidadeInterDAO.save(u);
		if(o.getIdUmidade()!=null) {
			return "ok";
		}else{
			return "erro";
		}		 
	}
		 
	@RequestMapping(value="/arduino/salvartemperatura",method = RequestMethod.GET)
	public  String salvarTemperatura(Temperatura t) {
		Temperatura o= temperaturaInterDAO.save(t);
		if(o.getIdTemperatura()!=null) {
			return "ok";
		}else{
			return "erro";
		}		 
	}
		 
	@RequestMapping(value="/arduino/salvarluminosidade",method = RequestMethod.GET)
	public  String salvarLuminosidade(Luminosidade l) {
		System.out.println(l.getDado());
		Luminosidade o=luminosidadeInterDAO.save(l);
		if(o.getIdLuminosidade()!=null) {
			return "ok";
		}else{
			return "erro";
		}		 
	}
	 
}
