package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
	private LocalDate date;
	private double discount;
	private double totalPrice;
	private String orderNr;
	private OrderStatus orderStatus;
	private ArrayList<OrderLine> orderLines;

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
