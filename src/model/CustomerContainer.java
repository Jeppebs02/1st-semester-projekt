package model;

import java.util.ArrayList;
import java.util.Iterator;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: CustomerContainer holds customers.
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
			if (currentCustomer.getCustomerID().equalsIgnoreCase(customerID)) {
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
	
	public boolean removeCustomer(Customer c) {
		return customers.remove(c);
	}
	
	public ArrayList<Customer> findAllCustomers(){
		return new ArrayList<>(this.customers);
	}
	
	
}
