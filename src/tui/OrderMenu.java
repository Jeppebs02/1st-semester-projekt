package tui;
import java.util.Scanner;

import model.Customer;
import model.Order;
import model.Product;

public class OrderMenu {

	public OrderMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		//TODO Start the TUI, call the ordermenu in our first usecase (for now)
	}
	
	public void orderMenu() {
		//TODO Here we should put the logic, so the different options in the menu
	}
	
	public int writeOrderMenu() {
		//TODO Print the TUI ordermenu and return the users choice to be used in orderMenu()
		return 0;
	}
	
	public Order createOffer() {
		//TODO Initiate creating an offer, this passes the method onto the orderController.
		return null;
	}
	
	public Product inputProduct() {
		//TODO pass this down to the order controller, and then to the product controller.
		return null;
	}
	
	public Customer inputCustomerID() {
		//TODO pass this down to the order controller, then to the customer controller.
		return null;
	}
	
	public boolean saveOffer() {
		//TODO pass down to order controller, to save the offer
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	//Used to get an integer from the user
	private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
	}

}

