package model;

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
		if(getEmployeeID() == null) {
			throw new NullPointerException("Employee ID is set null");
		}
		return employeeID;
	}

	

}
