package meemo.campaign.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

import javax.annotation.Generated;

@SpringBootApplication(scanBasePackages = {"meemo.campaign.service"})
@EnableWebFlux
@Generated(value="Spring Initializr")
public class MeemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeemoServiceApplication.class, args);
	}

}
