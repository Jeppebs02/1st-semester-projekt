package control;

import model.Customer;
import model.Order;
import model.Product;

public class OrderController {
	private Order currentOrder;

	
	public OrderController() {
		// TODO Auto-generated constructor stub
	}
	
	public Order createOffer() {
		//TODO Create a new Order object and save it to the field currentOrder
		return null;
	}
	
	public Product inputProduct(String barcode, int quaintity) {
		//TODO Find a product and a quantity to add to an orderline
		return null;
	}
	
	//Method overloading to add a "default" argument. Do not delete this pls
	
	public Product inputProduct(String barcode) {
		return inputProduct(barcode,1);
	}
	
	public Customer inputCustomerID(String customerID) {
		//TODO Find a customer and add to currentOrder
		return null;
	}
	
	public boolean saveOffer() {
		//TODO Take currentOrder and put it into orderContainer (i.e. save the order)
		return false;
	}

}
