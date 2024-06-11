package model;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class holds the fields that is specific for 
//employees in the system.
public class Employee extends Person{
	
	private String employeeID;
	private String password;
	private String username;
	
	
	public Employee(String name, String email, String phoneNr, String address, String password, String username, String employeeID) {
		super(name, email, phoneNr, address);
		this.password = password;
		this.username = username;
		this.employeeID = employeeID;
	}


	public String getEmployeeID() throws NullPointerException {
		if (employeeID == null) {
			throw new NullPointerException("employee ID cant be Null");
		}
		return employeeID;
	}


	public String getPassword() {
		return password;
	}


	public String getUsername() {
		return username;
	}

	public boolean authenticate(String password) {
		return this.password.equals(password);
	}

}
