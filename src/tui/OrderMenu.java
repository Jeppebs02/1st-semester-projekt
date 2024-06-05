package tui;
import java.time.LocalDate;
import java.util.Scanner;

import model.Customer;
import model.Order;
import model.OrderLine;
import model.Product;
import model.Person;
import control.*;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class contains the OrderMenu. Its the 
//interaction UI for the user.
public class OrderMenu {

	private OrderController oc;

	
	public OrderMenu() {
		oc = new OrderController();
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
			case 2: 
				changeOrderStatus(); //made in interation 2
				break;
			case 0:
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
		System.out.println(" (2) Ændre status på ordre"); //made in interation 2
		System.out.println(" (0) Tilbage");
		System.out.println("\n Vælg");
		int choice = getIntegerFromUser (keyboard);
		return choice; 
	}
	
	public void createOffer() {
		//TODO Initiate creating an offer, this passes the method onto the orderController.
		//OrderController oc = new OrderController();
		Scanner keyboard = new Scanner(System.in);
		
		oc.createOffer();
		
		String barcode = null;
		int quantity = 0;
		boolean foundProducts = false;
		boolean foundCustomer = false;
		String customerID = null;

		while (!foundProducts) {
			
			System.out.println("Indtast Stregkode på produktet:");
			barcode = String.valueOf(getIntegerFromUser(keyboard));
			System.out.println("Indtast antal af dette produkt:");
			quantity = getIntegerFromUser(keyboard); 
			
			Product currentProduct = oc.inputProduct(barcode, quantity);
			
			//null check
			if (currentProduct == null) {
				System.out.println("Stregkode findes ikke");
			} else if(quantity<=currentProduct.getInventory().getStock()) {
				System.out.println(currentProduct.getName() + " er tilføjet");
			}
			System.out.println("Skal der tilføjes flere produkter?");
			System.out.println("Ja(1) / Nej(0)");
			boolean correctChoice= false;
			int answer=0;
			while(!correctChoice) {
				answer = getIntegerFromUser(keyboard);
			if (answer == 0) {
				foundProducts = true;
				correctChoice=true;
				 
			}else if(answer == 1) {
				foundProducts= false;
				correctChoice=true;
				
			} else {
				System.out.println("Vælg venligst 1 for ja eller 0 for nej");
				correctChoice=false;
				}
			}
		}
		
		while (!foundCustomer) {
			System.out.println("Indtast Kunde ID:");
			customerID = String.valueOf(getIntegerFromUser(keyboard));
			
			Customer currentCustomer = oc.inputCustomerID(customerID);
			
			if (currentCustomer == null) {
				System.out.println("Kunde ID eksisterer ikke");
			} else {
				System.out.println(currentCustomer.getName() + " er tilføjet");
				foundCustomer = true;
			} 
		}
		
		oc.saveOffer();
		printOrderDesc();
	}

	//made in interation 2
	public void changeOrderStatus() {
		
		Scanner keyboard = new Scanner(System.in);
		boolean foundAnswer = false;
		boolean foundOrder = false;
		
		OrderStatusController osc = new OrderStatusController();
		
		while (!foundOrder) {
			
			System.out.println("Indtast ordre nummer:");
			String answer = keyboard.nextLine();
			Order order = osc.findOrderByNr(answer);
			
			if(order == null) {
				System.out.println("Order findes ikke - Prøv igen \n");
			} else {
				foundOrder = true;
			}
			
		}
		
		String statusAnswer = null;
		
		while (!foundAnswer) {
			System.out.println("Indtast den nye status på ordren");
			System.out.println("ACCEPTED, PAID, CANCELLED, ONHOLD, OVERDUE");
			statusAnswer = keyboard.nextLine().toUpperCase();
			if (!statusAnswer.equals("ACCEPTED")
					&& !statusAnswer.equals("PAID")
					&& !statusAnswer.equals("CANCELLED") 
					&& !statusAnswer.equals("ONHOLD")
					&& !statusAnswer.equals("OVERDUE")) {
				System.out.println("Status ukendt - prøv igen \n");
			} else {
				foundAnswer = true;
			}
		}
		osc.changeOrderStatus(statusAnswer);
		
		System.out.println("Orderen er nu ændret til: " + statusAnswer);
		
		printOrderAccept();
		
	}
	
	
	//Used to get an integer from the user
	private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        int i = keyboard.nextInt();
        keyboard.nextLine();
        return i;
	}

	private void printOrderDesc() {
		
		System.out.println("   **** Vestbjerg Byggecenter A/S ****       \n");
		System.out.println("Dato: "+ oc.getCurrentOrder().getTimeDateString() +"     Tid: "+ oc.getCurrentOrder().getTimeMMSSString() +" \n");
		System.out.println("Skal accepteres inden: "+oc.getCurrentOrder().getAcceptDeadlineString());
		System.out.println("---------------------------------\n");
		System.out.println("Order Nr: "+ oc.getCurrentOrder().getOrderNr());
		System.out.println("Order status: "+oc.getCurrentOrder().getOrderStatus());
		System.out.println("---------------------------------\n");
		
		for(OrderLine currLine:oc.getCurrentOrder().getOrderLines()) {
			int currQuantity= currLine.getQuantity();
			Product currProduct = currLine.getProduct();
			System.out.println(currProduct.getName() +"       Antal "+ currQuantity +" : Total "+ currLine.calculateOrderLinePrice() + " DKK" +"\n");
		
		}
		
		if(oc.getCurrentOrder().getCustomer().getCustomerCategory() != null) {
		System.out.println("Samlet rabat: " + oc.getCurrentOrder().getCustomer().getCustomerCategory().calculateDiscountPercent() + "%");
		}
		
		System.out.println( "Total pris = "+ oc.getCurrentOrder().calculateTotalPrice() + " DKK");
		System.out.println();
	    System.out.println("*********************************\n");
	    System.out.println("Dette tilbud er sendt til: " + oc.getCurrentOrder().getCustomer().getEmail());
	    System.out.println();
	    System.out.println("*********************************\n");
	    System.out.println("Du er blevet betjent af: " + oc.getCurrentEmployee().getName());
	    System.out.println();
	}
	//TODO
	private void printOrderAccept() {
		
		System.out.println("   **** Vestbjerg Byggecenter A/S ****       \n");
		System.out.println("Dato: "+ LocalDate.now() + "\n");
		System.out.println("Skal betales inden: "+oc.getCurrentOrder().getPaymentDeadlineString());
		System.out.println("---------------------------------\n");
		System.out.println("Order Nr: "+ oc.getCurrentOrder().getOrderNr());
		System.out.println("Order status: "+oc.getCurrentOrder().getOrderStatus());
		System.out.println("---------------------------------\n");
		
		for(OrderLine currLine:oc.getCurrentOrder().getOrderLines()) {
			int currQuantity= currLine.getQuantity();
			Product currProduct = currLine.getProduct();
			System.out.println(currProduct.getName() +"       Antal "+ currQuantity +" : Total "+ currLine.calculateOrderLinePrice() + " DKK" +"\n");
		
		}
		
		if(oc.getCurrentOrder().getCustomer().getCustomerCategory() != null) {
		System.out.println("Samlet rabat: " + oc.getCurrentOrder().getCustomer().getCustomerCategory().calculateDiscountPercent() + "%");
		}
		
		System.out.println( "Total pris = "+ oc.getCurrentOrder().calculateTotalPrice() + " DKK");
		System.out.println();
	    System.out.println("*********************************\n");
	    System.out.println("Du er blevet betjent af: " + oc.getCurrentEmployee().getName());
	    System.out.println();
	    System.out.println("En pakke liste er blevet sendt til lageret. \nDu vil få en yderligere mail ang. levering.\n");
	}
}

