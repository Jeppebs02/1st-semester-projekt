package model;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: this superclass holds the fields that is common for all 
//types of persons in our system.
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
//		if (name.matches(".*\\d.*")) {
//	        throw new IllegalArgumentException("Name cant contain numbers");
//	    }
//		Vi snakkede om at introducere en exception på fx at indtaste tal i et navn ved brugen af REGEX da det er 2. semester, bruger vi energien på noget andet
		return name;
	}

	public String getEmail() throws NullPointerException {
		if (email == null) {
		throw new NullPointerException("E-mail cant be Null");
		}
		return email;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
