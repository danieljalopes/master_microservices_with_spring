package eu.danieljalopes.microservice.limitsservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.danieljalopes.microservice.limitsservice.bean.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {

	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsConfigurations() {
		return new LimitsConfiguration(1000, 1);
	}
}
