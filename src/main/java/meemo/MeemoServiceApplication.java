package meemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication(scanBasePackages = {"meemo"})
public class MeemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeemoServiceApplication.class, args);
	}

}


