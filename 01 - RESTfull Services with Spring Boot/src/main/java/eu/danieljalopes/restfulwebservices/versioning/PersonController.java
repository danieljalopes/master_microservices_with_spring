package eu.danieljalopes.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	/*------------------------------------------------------
	 * 
	 * Using URI to return a different version of a Person
	 * 
	 -----------------------------------------------------*/
	
	@GetMapping("v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Bob", "Marley");
	}
	
	@GetMapping("v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2("Bob", "Marley");
	}
	
	
	/*------------------------------------------------------------
	 * 
	 * Using URI params to return a different version of a Person
	 * 
	 ------------------------------------------------------------*/
	
	@GetMapping(value="/person/params", params="version=1")
	public PersonV1 getPersonV1Param() {
		return new PersonV1("Bob", "Marley");
	}
	
	@GetMapping(value="/person/params", params="version=2")
	public PersonV2 getPersonV2Param() {
		return new PersonV2("Bob", "Marley");
	}
	
	/*-------------------------------------------------------------
	 * 
	 * Using the headers to return a different version of a Person
	 * 
	 ------------------------------------------------------------*/
	
	@GetMapping(value="/person/headers", headers="X-API-VERSION=1")
	public PersonV1 getPersonV1Header() {
		return new PersonV1("Bob", "Marley");
	}
	
	@GetMapping(value="/person/headers", headers="X-API-VERSION=2")
	public PersonV2 getPersonV2Header() {
		return new PersonV2("Bob", "Marley");
	}
	
	/*-------------------------------------------------------------
	 * 
	 * Using content negotiation to return a different version of a Person
	 * 
	 ------------------------------------------------------------*/
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 getPersonV1Produces() {
		return new PersonV1("Bob", "Marley");
	}
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 getPersonV2Produces() {
		return new PersonV2("Bob", "Marley");
	}
	
}