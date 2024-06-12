package control;

import java.util.ArrayList;

import model.Customer;
import model.Employee;
import model.Order;
import model.OrderContainer;
import model.OrderLine;
import model.Product;
import model.ProductContainer;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class contains the OrderController, 
//enabling userinput from the TUI level to interact with the modellayer, 
//without compromising the architecture. 
public class OrderController {
	private Order currentOrder;

	public OrderController() {
		
	}
	
	public Order getCurrentOrder() {
		return currentOrder;
	}
	
	
	public Order createOffer() {
		// Create a new Order object and save it to the field currentOrder
		Order newOrder = new Order();
		currentOrder = newOrder;
		return newOrder;
	}
	
	public Product inputProduct(String barcode, int quantity) {
		// Find a product and a quantity to add to an orderline and add orderline to currentOrder
		ProductController pc = new ProductController();
		Product orderProduct = pc.inputProduct(barcode);
		OrderLine ol = new OrderLine(quantity, orderProduct);
		
		//check product for null and if stock is greater than quantity
		if(orderProduct != null) {
			if(orderProduct.getInventory().getStock() >= quantity) {
				orderProduct.getInventory().changeStock(-quantity);
				currentOrder.addOrderLine(ol);
			}
		}
		return orderProduct; 

	}	
	//Method overloading to add a "default" argument. Do not delete this pls
	//public Product inputProduct(String barcode) {
		//return inputProduct(barcode,1);
	//}
	
	public Customer inputCustomerID(String customerID) {
		//Find a customer and add to currentOrder
		CustomerController cc = new CustomerController();
		Customer orderCustomer = cc.inputCustomerID(customerID);
		
		if(orderCustomer != null) {
			currentOrder.setCustomer(orderCustomer);
		}		
		return orderCustomer;
	}
	
	public String generateOrderNr() {
		OrderContainer oc = OrderContainer.getInstance();
		return oc.generateOrderNr();
	}
	
	public boolean saveOffer(String orderNr) {
		// Take currentOrder and put it into orderContainer (i.e. save the order)
		LoginController lc =  new LoginController();
		Employee  user = lc.getLoginUser();
		currentOrder.setEmployee(user);
		OrderContainer oc = OrderContainer.getInstance();
		return oc.saveOffer(currentOrder,orderNr);

	}
	
	public Product findProductByBarcode(String barcode) {
		ProductController pc = new ProductController();
		return pc.inputProduct(barcode);
	}
	
	public ArrayList<OrderLine> getOrderLines() {
		return currentOrder.getOrderLines();
	}
	
	public Employee getCurrentEmployee() {
		LoginController lc = new LoginController();
		return lc.getLoginUser();
	}
	
	public ArrayList<Order> getOrders() {
		OrderContainer oc = OrderContainer.getInstance();
		return oc.getOrderList();
	}
	
	
}
