package model;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class holds specific information and fields 
//needed for a customers in the system.
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


	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


	public CustomerCategory getCustomerCategory() {
		return customerCategory;
	}


	public void setCustomerCategory(CustomerCategory customerCategory) throws IllegalArgumentException {
		if (customerCategory == null) {
			throw new IllegalArgumentException("CustomerCategory cant be null");
		}
		this.customerCategory = customerCategory;
	}
	
	
	
	
	

}
