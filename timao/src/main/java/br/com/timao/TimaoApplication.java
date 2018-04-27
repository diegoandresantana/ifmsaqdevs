package br.com.timao;

import java.io.Serializable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.timao.entity.Cidade;
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
