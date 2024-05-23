package tui;
import java.util.Scanner;

import model.Customer;
import model.Order;
import model.Product;
import control.*;

public class OrderMenu {

	public OrderMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		//TODO Start the TUI, call the ordermenu in our first usecase (for now)
		orderMenu();
	}
	
	public void orderMenu() {
		//TODO Here we should put the logic, so the different options in the menu
		boolean running = true;
		while (running) {
			int choice = writeOrderMenu();
			switch (choice) {
			case 1:
				createOffer();
				break;
			case 0:
				System.out.println("Tak for denne gang");
				running = false;
				break;
			default:
				System.out.println("En uforklarlig fejl er sket med choice = " + choice);
				break; 
			}
		}
	}
	
	public int writeOrderMenu() {
		//TODO Print the TUI ordermenu and return the users choice to be used in orderMenu()
		Scanner keyboard = new Scanner(System.in);
		System.out.println("** Ordre Menu **");
		System.out.println(" (1) Opret et Tilbud");
		System.out.println(" (0) Luk Menu");
		System.out.println("\n Vælg");
		int choice = getIntegerFromUser (keyboard);
		return choice; 
	}
	
	public Order createOffer() {
		//TODO Initiate creating an offer, this passes the method onto the orderController.
		OrderController oc = new OrderController();
		Scanner keyboard = new Scanner(System.in);
		
		
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

