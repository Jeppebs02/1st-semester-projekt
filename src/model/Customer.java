package model;

public class Customer extends Person{
	private String customerID;
	private CustomerCategory customerCategory;

	public Customer(String name, String email, String phoneNr, String address, String customerID) {
		super(name, email, phoneNr, address);
		this.customerID=customerID;
		
	}


	public String getCustomerID() {
		return customerID;
	}


	public CustomerCategory getCustomerCategory() {
		return customerCategory;
	}


	public void setCustomerCategory(CustomerCategory customerCategory) {
		this.customerCategory = customerCategory;
	}
	
	
	
	
	

}
