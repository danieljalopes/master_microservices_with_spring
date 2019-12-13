package eu.danieljalopes.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@GetMapping("v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Bob", "Marley");
	}
	
	@GetMapping("v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2("Bob", "Marley");
	}
	
	@GetMapping(value="/person", params="version=1")
	public PersonV1 getPersonV1Param() {
		return new PersonV1("Bob", "Marley");
	}
	
	@GetMapping(value="/person", params="version=2")
	public PersonV2 getPersonV2Param() {
		return new PersonV2("Bob", "Marley");
	}
	
	@GetMapping(value="/person", headers="X-API-VERSION=1")
	public PersonV1 getPersonV1Header() {
		return new PersonV1("Bob", "Marley");
	}
	
	@GetMapping(value="/person", headers="X-API-VERSION=2")
	public PersonV2 getPersonV2Header() {
		return new PersonV2("Bob", "Marley");
	}
}