package developergirls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DeveloperGirlsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeveloperGirlsApplication.class, args);
	}
	@RequestMapping("/")
	  String index() {
	    return "redirect:/home.html";
	  }

	 
}
