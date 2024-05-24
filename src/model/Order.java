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
	private Customer customer;
	private Employee employee;

	public Order() {
		//random string orderNR
		// order nr is set in container
		this.orderStatus=OrderStatus.ONHOLD;
		orderLines = new ArrayList<>();
		this.date = LocalDate.now();
		
	}

	
	public double calculateTotalPrice() {
		double total=0;
		
		for(OrderLine currLine:orderLines) {
			int currQuantity= currLine.getQuantity();
			double currProductSalesPrice = currLine.getProduct().getPrice().getSalesPrice();
			total=total+(currQuantity*currProductSalesPrice);
			
		}
		
		return total;
	}
	
	
	
	public String getOrderNr() {
		return orderNr;
	}


	public void setOrderNr(String orderNr) {
		this.orderNr = orderNr;
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus=orderStatus;
	}
	
	public void setDiscount(double discount) {
		this.discount=discount;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void addOrderLine(OrderLine orderLine) throws IllegalArgumentException {
		if(orderLine==null) {
			throw new IllegalArgumentException("orderLine cannot be null");
		}
		orderLines.add(orderLine);
	}
	
	
	

}
