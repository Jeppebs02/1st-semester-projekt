package gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.table.AbstractTableModel;

import control.OrderController;
import model.Order;

public class SearchOrderNrTableModel extends AbstractTableModel{
	
		private final String[] COLUMN_NAMES = {"Ordre Nr", "Status", "Oprettet", "Kunde navn", "Tlf nr.", "E-mail", "Kunde ID"};
	    private OrderController oc;
	    private ArrayList<Order> orders;
	    
	    public SearchOrderNrTableModel() {
	    	oc = new OrderController();
	    	orders = new ArrayList<>(); 	
	    }
	    
	    public void initOrderList() {
	    	orders = oc.getOrders();
	    	sortOrderListByOrderNr();
	    }
	    
	    public void sortOrderListByOrderNr() {
	    	Collections.sort(orders, new Comparator<Order>() {
	            public int compare(Order order1, Order order2) {
	                return order1.getOrderNr().compareToIgnoreCase(order2.getOrderNr());
	            }
	        });
	    }

		@Override
		public int getRowCount() {
			return orders.size();
		}

		@Override
		public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override
		public String getColumnName(int column) {
			return COLUMN_NAMES[column];
		}
		
		public ArrayList<Order> getOrders() {
			return orders;
		}

		public void setOrders(ArrayList<Order> customers) {
			this.orders = customers;
		}

		@Override
		public Object getValueAt(int r, int c) {
			String returnString = ""; 
			
			if (c==0) {
				returnString = orders.get(r).getOrderNr();
			} else if (c==1) {
				returnString = orders.get(r).getOrderStatus();
			} else if (c==2) {
				returnString = orders.get(r).getTimeDateString();
			} else if (c==3) {
				returnString = orders.get(r).getCustomer().getName();
			} else if (c==4) {
				returnString = orders.get(r).getCustomer().getPhoneNr();
			} else if (c==5) {
				returnString = orders.get(r).getCustomer().getEmail();
			} else if (c==6) {
				returnString = orders.get(r).getCustomer().getCustomerID();
			}
			return returnString;
		}
		
		public Order getSelectedOrder(int r) {
			return orders.get(r); 
		}
}
