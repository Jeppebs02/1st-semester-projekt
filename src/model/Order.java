package model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class makes orders. 
public class Order {
	private LocalDateTime date;
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
		this.date = LocalDateTime.now();
		
	}

	public double calculateTotalPrice() {
		double total=0;
		
		for(OrderLine currLine:orderLines) {
			int currQuantity = currLine.getQuantity();
			double currProductSalesPrice = currLine.getProduct().getPrice().getSalesPrice();
			
			total=total+(currProductSalesPrice*currQuantity);
			
		}
		if(customer!=null) {
			double customerDiscount = customer.getCustomerCategory().getDiscount();
			total = total*customerDiscount;
		}
		return total;
	}
	
	public String getOrderNr() throws NullPointerException {
		if (orderNr == null) {
			throw new NullPointerException("Order Nr. cant be Null");
		}
		return orderNr;
	}
	
	public String getOrderStatus() throws NullPointerException {
		if (orderStatus == null) {
			throw new NullPointerException("Order Status cant be null");
		}
		return orderStatus.toString();
	}
	
	public String getTimeMMSSString() {
		return ""+date.getHour()+":"+date.getMinute()+":"+date.getSecond();
	}
	
	
	public String getAcceptDeadlineString() {
		LocalDateTime AcceptDeadline = date.plusDays(7);
		return ""+AcceptDeadline.getDayOfMonth()+"-"+AcceptDeadline.getMonthValue()+"-"+AcceptDeadline.getYear();
	}

	public String getTimeDateString() {
		return ""+date.getDayOfMonth()+"-"+date.getMonthValue()+"-"+date.getYear();
	}


	public String getPaymentDeadlineString() {
		LocalDate paymentDeadline = LocalDate.now();
		
		if(customer.getCustomerCategory() == null) {
			paymentDeadline = paymentDeadline.plusDays(7);
		} else {
			paymentDeadline = paymentDeadline.plusDays(customer.getCustomerCategory().getPaymentDeadline());
		}
		
		return ""+paymentDeadline.getDayOfMonth()+"-"+paymentDeadline.getMonthValue()+"-"+paymentDeadline.getYear();
		
	}
	
	public ArrayList<OrderLine> getOrderLines() throws NullPointerException {
		if (orderLines == null) {
			throw new NullPointerException("orderLines cant be Null");
		}
		return orderLines;
	}


	public void setOrderNr(String orderNr) throws IllegalArgumentException {
		if(orderNr == null) {
			throw new IllegalArgumentException("Order NR. cant be null");
		}
		this.orderNr = orderNr;
	}


	public void setOrderStatus(OrderStatus orderStatus) throws IllegalArgumentException {
		if(orderStatus == null) {
			throw new IllegalArgumentException("Order Status cannot be null");
		}
		this.orderStatus=orderStatus;
	}
	
	
	public void setCustomer(Customer customer) throws IllegalArgumentException {
		if(customer == null) {
			throw new IllegalArgumentException("Customer cannot be null");
		}
		this.customer = customer;
	}

	public void setEmployee(Employee employee) throws IllegalArgumentException {
		if(employee == null) {
			throw new IllegalArgumentException("employee cannot be null");
		}
		this.employee = employee;
	}
	
	public void addOrderLine(OrderLine orderLine) throws NullPointerException {
		if(orderLine==null) {
			throw new NullPointerException("orderLine cannot be null");
		}
		orderLines.add(orderLine);
	}


	public Customer getCustomer() throws NullPointerException {
		if (customer == null) {
			throw new NullPointerException("Customer cant be Null");
		}
		return customer;
	}
	
	public boolean removeOrderLine(OrderLine ol) {
		return orderLines.remove(ol);
	}
	

}
