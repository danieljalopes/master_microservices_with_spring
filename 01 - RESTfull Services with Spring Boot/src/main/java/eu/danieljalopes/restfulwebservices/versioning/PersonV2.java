package eu.danieljalopes.restfulwebservices.versioning;

public class PersonV2 {

	private Name name;

	public PersonV2() {
		super();
		this.name = new Name("Bob", "Marley");
	}
	
	public PersonV2(String firstname, String lastName) {
		super();
		this.name = new Name(firstname, lastName);
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
	
}
