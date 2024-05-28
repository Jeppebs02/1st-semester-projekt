package control;

import model.Customer;
import model.CustomerContainer;

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

	
}
