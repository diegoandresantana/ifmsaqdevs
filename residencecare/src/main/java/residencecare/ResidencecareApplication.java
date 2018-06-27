package residencecare;

import org.apache.catalina.Context;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@SpringBootApplication
@Controller
public class ResidencecareApplication {
	 
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		TomcatContextCustomizer contextCustomizer = new TomcatContextCustomizer() {
			 

			@Override
			public void customize(Context context) {
				context.addWelcomeFile("login.html");
				context.addWelcomeFile("dashboard.html");
				context.setWebappVersion("3.1");
				
			}
		};
		factory.addContextCustomizers(contextCustomizer);
		return factory;
	}

	public static void main(String[] args) {
		SpringApplication.run(ResidencecareApplication.class, args);
	}
}
