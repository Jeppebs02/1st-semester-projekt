package model;

import java.util.ArrayList;
import java.util.Iterator;

public class OrderContainer {
	private ArrayList<Order> orders;
	private static OrderContainer instance;

	private OrderContainer() {
		orders = new ArrayList<>();
	}

	public static OrderContainer getInstance() {
		if (instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	
	public boolean saveOffer(Order order) {
		boolean answer = false;
		if(order==null) {
			answer=false;
		}else {
			orders.add(order);
			answer=true;
		}
		return answer;
	}
	
}
