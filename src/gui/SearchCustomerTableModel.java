package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import control.CustomerController;
import control.OrderController;
import model.Customer;
import model.OrderLine;

public class SearchCustomerTableModel extends AbstractTableModel{
	
		private final String[] COLUMN_NAMES = {"Navn", "Email", "Tlf Nr", "Adresse", "Kunde ID"};
	    private CustomerController cc;
	    private ArrayList<Customer> customers;
	    
	    public SearchCustomerTableModel() {
	    	cc = new CustomerController();
	    	customers = new ArrayList<>();
	    	
	    }
	    
	    public void initCustomerList() {
	    	customers = cc.printAllCustomers();
	    }

	 

		@Override
		public int getRowCount() {
			return customers.size();
		}

		@Override
		public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override
		public String getColumnName(int column) {
			return COLUMN_NAMES[column];
		}
		
		
		

		public ArrayList<Customer> getCustomers() {
			return customers;
		}



		public void setCustomers(ArrayList<Customer> customers) {
			this.customers = customers;
		}



		@Override
		public Object getValueAt(int r, int c) {
			String returnString = ""; 
			
			if (c==0) {
				returnString = customers.get(r).getName();
			} else if (c==1) {
				returnString = customers.get(r).getEmail();
			} else if (c==2) {
				returnString = customers.get(r).getPhoneNr();
			} else if (c==3) {
				returnString = customers.get(r).getAddress();
			} else if (c==4) {
				returnString = customers.get(r).getCustomerID();
			}
			return returnString;
		}
		
		
}
