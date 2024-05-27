package control;

import model.Customer;
import model.CustomerContainer;

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

	
}
