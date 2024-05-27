package model;

public abstract class Person {
	private String name;
	private String email;
	private String phoneNr;
	private String address;

	
	
	public Person(String name, String email, String phoneNr, String address) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNr = phoneNr;
		this.address = address;
	}

	public String getName() throws NullPointerException {
		if (name == null) {
		throw new NullPointerException("Name cant be Null");
		}
		return name;
	}

	public String getEmail() throws NullPointerException {
		if (email == null) {
		throw new NullPointerException("E-mail cant be Null");
		}
		return email;
	}
	
	

}
