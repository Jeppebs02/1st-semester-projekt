package model;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomerContainer {
	private ArrayList<Customer> customers;
	private static CustomerContainer instance;

	private CustomerContainer() {
		customers = new ArrayList<>();
	}

	public static CustomerContainer getInstance() {
		if (instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}

	public Customer findCustomerByID(String customerID) {
		Customer foundCustomer = null;
		Customer currentCustomer = null;
		boolean searching = true;
		Iterator<Customer> iterator = customers.iterator();

		while (searching && iterator.hasNext()) {
			currentCustomer = iterator.next();
			if (currentCustomer.getCustomerID().equals(customerID)) {
				foundCustomer = currentCustomer;
				searching = false;
			} 
		}
		return foundCustomer;
	}
	
	public void addCustomerToContainer(Customer customer) {
		if(customer != null) {
			customers.add(customer);
		}
	}
	
	
	
	
	
}
