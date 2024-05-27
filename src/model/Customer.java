package model;

public class Customer extends Person{
	private String customerID;
	private CustomerCategory customerCategory;

	public Customer(String name, String email, String phoneNr, String address, String customerID) {
		super(name, email, phoneNr, address);
		this.customerID=customerID;
		
	}


	public String getCustomerID() throws NullPointerException {
		if (customerID == null) {
            throw new NullPointerException("Customer ID cant be Null");
        }
		return customerID;
	}


	public CustomerCategory getCustomerCategory() throws NullPointerException {
	
		return customerCategory;
	}


	public void setCustomerCategory(CustomerCategory customerCategory) throws IllegalArgumentException {
		if (customerCategory == null) {
			throw new IllegalArgumentException("CustomerCategory cant be null");
		}
		this.customerCategory = customerCategory;
	}
	
	
	
	
	

}
