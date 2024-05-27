package model;

import java.util.ArrayList;
import java.util.Iterator;

public class OrderContainer {
	private ArrayList<Order> orders;
	private static OrderContainer instance;
	private int orderNrCounter;

	private OrderContainer() {
		orders = new ArrayList<>();
		orderNrCounter=0;
	}

	public static OrderContainer getInstance() {
		if (instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	
	public boolean saveOffer(Order order) {
		boolean answer = false;
		if (order==null) {
			answer=false;
		} else {
			order.setOrderNr(generateOrderNr());
			orders.add(order);
			answer=true;
		}
		return answer;
	}
	
	public String generateOrderNr() {
		orderNrCounter=orderNrCounter+1;
		return String.valueOf(orderNrCounter);
	}

	public Order findOrderByNr (String orderNr) {
		Order foundOrder = null;
		Order currentOrder = null;
		boolean searching = true;
		Iterator<Order> iterator = orders.iterator();

		while (searching && iterator.hasNext()) {
			currentOrder = iterator.next();
			if (currentOrder.getOrderNr().equals(orderNr)) {
				foundOrder = currentOrder;
				searching = false;
			} 
		}
		return foundOrder;
		
		
	}
	
	
}
