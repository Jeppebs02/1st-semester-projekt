package model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
	private LocalDateTime date;
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
		this.date = LocalDateTime.now();
		
	}

	public double calculateTotalPrice() {
		double total=0;
		
		
		for(OrderLine currLine:orderLines) {
			int currQuantity= currLine.getQuantity();
			double currProductSalesPrice = currLine.getProduct().getPrice().getSalesPrice();
			
			total=total+(currProductSalesPrice*currQuantity);
			
		}
		if(customer.getCustomerCategory()==null) {
			return total;
		}else {
			double customerDiscount=customer.getCustomerCategory().getDiscount();
			return total*customerDiscount;
		}
		
	}
	
	public String getOrderNr() throws NullPointerException {
//		if (orderNr == null) {
//			throw new NullPointerException("Order Nr. cant be Null");
//		}
		return orderNr;
	}
	
	public String getOrderStatus() {
		return orderStatus.toString();
	}
	
	public String getTimeMMSSString() throws NullPointerException {
		if (date == null) {
			throw new NullPointerException("date cant be Null");
		}
		return ""+date.getHour()+":"+date.getMinute()+":"+date.getSecond();
	}
	
	
	public String getAcceptDeadlineString() {
		return String.valueOf(date.plusDays(7));
	}

	public String getTimeDateString() throws NullPointerException {
		if (date == null) {
			throw new NullPointerException("date cant be Null");
		}
		return ""+date.getDayOfMonth()+"-"+date.getMonthValue()+"-"+date.getYear();
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
	
	public void addOrderLine(OrderLine orderLine) throws IllegalArgumentException {
		if(orderLine==null) {
			throw new IllegalArgumentException("orderLine cannot be null");
		}
		orderLines.add(orderLine);
	}


	public Customer getCustomer() throws NullPointerException {
		if (customer == null) {
			throw new NullPointerException("Customer cant be Null");
		}
		return customer;
	}
	
	
	

}
