package eu.danieljalopes.restfulwebservices.versioning;

public class PersonV1 {
	private String name;

	
	public PersonV1() {
		super();
	}


	public PersonV1(String firstName, String lastName) {
		super();
		this.name = firstName + " " + lastName;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	

}
