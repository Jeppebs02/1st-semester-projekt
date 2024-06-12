package control;

import java.util.ArrayList;

import model.Customer;
import model.CustomerContainer;
import model.Employee;
import model.OrderContainer;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class contains the CustomerController, 
//enabling userinput from the TUI level to interact with the modellayer, 
//without compromising the architecture. 
public class CustomerController {
	
	private Customer currentCustomer;

	public CustomerController() {
	
	}

	public Customer inputCustomerID(String customerID) {
		CustomerContainer cc = CustomerContainer.getInstance();
		currentCustomer = cc.findCustomerByID(customerID);
		return cc.findCustomerByID(customerID);
	}

	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public Customer createCustomer(String name, String email, String phoneNr, String address) {
		String customerID = phoneNr;
		Customer c = new Customer(name, email, phoneNr, address, customerID);
		CustomerContainer.getInstance().addCustomerToContainer(c);;
		return c;
	}
	
	public boolean removeCustomerByID(String customerID) {
		Customer c = inputCustomerID(customerID);
		return CustomerContainer.getInstance().removeCustomer(c);
	}
	
	public void updateCustomer(String customerID, String name, String email, String phoneNr, String address) {
		Customer c = inputCustomerID(customerID);
		
		if(c == null) {
			throw new IllegalArgumentException("Customer with this ID does not exists");
		} else {
			c.setAddress(address);
			c.setEmail(email);
			c.setName(name);
			c.setPhoneNr(phoneNr);
		}
	}
	
	public ArrayList<Customer> printAllCustomers() {
		return CustomerContainer.getInstance().findAllCustomers();	
	}
	
	public String getCustomerNameByID(String customerID) {
		CustomerContainer cc = CustomerContainer.getInstance();
		return cc.getCustomerNameByID(customerID);
	}
	
	
	
	//Search in GUI
	public Customer getCustomerByID(String customerID) {
		CustomerContainer cc = CustomerContainer.getInstance();
		Customer currentCustomer = cc.findCustomerByID(customerID);
		return currentCustomer;
	}
	
	public Customer getCustomerByPhoneNr(String phoneNr) {
		return getCustomerByID(phoneNr);
	}
	
	public Customer getCustomerByEmail(String email) {
		CustomerContainer cc = CustomerContainer.getInstance();
		return cc.findCustomerByEmail(email);
	}
	
	public ArrayList<Customer> getCustomersByName(String name){
		CustomerContainer cc = CustomerContainer.getInstance();
		return cc.findCustomersByName(name);
	}
	
	
}
