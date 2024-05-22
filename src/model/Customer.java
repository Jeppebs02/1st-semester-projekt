package model;

public class Customer extends Person{
	private String customerID;

	public Customer(String name, String email, String phoneNr, String address, String customerID) {
		super(name, email, phoneNr, address);
		this.customerID=customerID;
		
	}


	public String getCustomerID() {
		return customerID;
	}
	
	
	

}
