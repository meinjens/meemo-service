package meemo.campaign.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication(scanBasePackages = {"meemo.campaign.service"})
@EnableWebFlux
public class MeemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeemoServiceApplication.class, args);
	}

}
