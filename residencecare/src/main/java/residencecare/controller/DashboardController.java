package residencecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import residencecare.dao.inter.ChuvaInterDAO;
import residencecare.dao.inter.TemperaturaInterDAO;
import residencecare.entity.Temperatura;

@RestController
public class DashboardController {
	
	@Autowired
	private ChuvaInterDAO chuvaInterDAO;
	@Autowired
	private TemperaturaInterDAO temperaturaInterDAO;
		 
	@RequestMapping(value="/dashboard/temperaturaAtual",method = RequestMethod.GET)
	public  Temperatura  getTemperaturaAtual() {
		return (Temperatura) temperaturaInterDAO.lastItem();
	}
	
	
	 
}
