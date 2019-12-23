package eu.danieljalopes.microservice.currrencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("eu.danieljalopes.microservice.currrencyconversionservice")
public class CurrrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrrencyConversionServiceApplication.class, args);
	}

}
