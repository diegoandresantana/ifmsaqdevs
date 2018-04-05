package residencecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import residencecare.dao.inter.ChuvaInterDAO;
import residencecare.entity.Chuva;

@RestController
public class ArduinoController {
	
	@Autowired
	private ChuvaInterDAO chuvaInterDAO;
		 
	@RequestMapping(value="/arduino/salvarchuva",method = RequestMethod.GET)
	public  String salvarChuva(Chuva c) {
		Chuva o=chuvaInterDAO.save(c);
		if(o.getIdChuva()!=null) {
			return "ok";
		}else{
			return "erro";
		}		 
	}
	 
	
	 
}
