package control;
import java.util.Scanner;

import model.Customer;
import model.Employee;
import model.Order;
import model.OrderContainer;
import model.OrderLine;
import model.Product;

public class OrderController {
	private Order currentOrder;

	
	public OrderController() {
		
	}
	
	public Order createOffer() {
		// Create a new Order object and save it to the field currentOrder
		Order newOrder = new Order();
		currentOrder = newOrder;
		return newOrder;
	}
	
	public Product inputProduct() {
		// Find a product and a quantity to add to an orderline and add orderline to currentOrder
		String barcode = null;
		int quantity = 0;
		ProductController pc = new ProductController();
		Scanner keyboard = new Scanner(System.in); 
		
		barcode = String.valueOf(getIntegerFromUser(keyboard));
		quantity = getIntegerFromUser(keyboard);
		
		Product orderProduct = pc.inputProduct(barcode);
		OrderLine ol = new OrderLine(quantity, orderProduct);
		currentOrder.addOrderLine(ol);
		return orderProduct;
	}
	
	//Method overloading to add a "default" argument. Do not delete this pls
	public Product inputProduct(String barcode) {
		return inputProduct(barcode,1);
	}
	
	public Customer inputCustomerID(String customerID) {
		//Find a customer and add to currentOrder
		CustomerController cc = new CustomerController();
		Customer orderCustomer = cc.inputCustomerID(customerID);
		currentOrder.setCustomer(orderCustomer);
		return orderCustomer;
	}
	
	public boolean saveOffer() {
		// Take currentOrder and put it into orderContainer (i.e. save the order)
		LoginController lc =  new LoginController();
		Employee  user = lc.retrieveLoginUser();
		currentOrder.setEmployee(user);
		OrderContainer oc = OrderContainer.getInstance();
		return oc.saveOffer(currentOrder);

	}
	
	private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            keyboard.nextLine();
        }
        int i = keyboard.nextInt();
        keyboard.nextLine();
        return i;
	}
}
