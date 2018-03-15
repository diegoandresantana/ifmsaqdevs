package br.com.timao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//  localhost:8090/
@SpringBootApplication
@Controller
public class TimaoApplication {
	@RequestMapping("/")
    @ResponseBody
    public String index(){
        return "Não é que funciona!!";
    }
	public static void main(String[] args) {
		SpringApplication.run(TimaoApplication.class, args);
	}
}
