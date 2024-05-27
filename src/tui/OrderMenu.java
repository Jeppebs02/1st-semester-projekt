package tui;
import java.util.Scanner;

import model.Customer;
import model.Order;
import model.OrderLine;
import model.Product;
import model.Person;
import control.*;

public class OrderMenu {

	OrderController oc;
	
	
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
				changeOrderStatus();
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
		System.out.println(" (2) Ændre status på ordre");
		System.out.println(" (0) Luk Menu");
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
			} else {
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

	public void changeOrderStatus() {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Indtast ordre nummer:");
		String answer = keyboard.nextLine();
		
		OrderStatusController osc = new OrderStatusController();
		
		osc.findOrderByNr(answer);
		
		System.out.println("Indtast den nye status på ordren");
		System.out.println("ACCEPTED, PAID, CANCELLED, ONHOLD, OVERDUE");
		String statusAnswer = keyboard.nextLine();
		
		osc.changeOrderStatus(statusAnswer);
		
		System.out.println("Orderen er nu ændret til: " + statusAnswer);
		
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
		System.out.println("Dato: "+ oc.getCurrentOrder().getTimeDate() +"     Tid: "+ oc.getCurrentOrder().getTimeMMSS() +" \n");
		System.out.println("---------------------------------\n");
		System.out.println("Order Nr: "+ oc.getCurrentOrder().getOrderNr());
		System.out.println("---------------------------------\n");
		
		for(OrderLine currLine:oc.getCurrentOrder().getOrderLines()) {
			int currQuantity= currLine.getQuantity();
			Product currProduct = currLine.getProduct();
			System.out.println(currProduct.getName() +"       Antal "+ currQuantity +" : Total "+ currLine.calculateOrderLinePrice() + " DKK" +"\n");
		
		}
		System.out.println( "Total pris = "+ oc.getCurrentOrder().calculateTotalPrice() + " DKK");
		System.out.println();
	    System.out.println("*********************************\n");
	    System.out.println("Dette tilbud er sendt til: " + oc.getCurrentOrder().getCustomer().getEmail());
	    System.out.println();
	    System.out.println("*********************************\n");
	    System.out.println("Du er blevet betjent af: " + oc.getCurrentEmployee().getName());
	}
}

