package residencecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import residencecare.dao.inter.ChuvaInterDAO;
import residencecare.entity.Chuva;

@RestController
public class Dashboard {
	
	@Autowired
	private ChuvaInterDAO<Chuva, Long> chuvaInterDAO;
	
	 @RequestMapping("/")
	    public String welcome() {//Welcome page, non-rest
	        return "Welcome to RestTemplate Example.";
	    }
	 
	 @RequestMapping(value="/dashboard/",method = RequestMethod.GET)
	public  Chuva  getTemperaturaAtual() {
		return (Chuva) chuvaInterDAO.getLastObject();
	}
	 
}
