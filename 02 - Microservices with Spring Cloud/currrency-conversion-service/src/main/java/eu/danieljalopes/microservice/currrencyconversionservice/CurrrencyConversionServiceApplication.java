package eu.danieljalopes.microservice.currrencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("eu.danieljalopes.microservice.currrencyconversionservice")
@EnableDiscoveryClient
public class CurrrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrrencyConversionServiceApplication.class, args);
	}

}
