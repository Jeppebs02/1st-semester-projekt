package tui;

import java.util.Scanner;

import control.CustomerController;
import model.Customer;

public class CustomerMenu {

	private CustomerController cc;
	
	public CustomerMenu () {
		cc = new CustomerController();

	}
	
	public void start() {
		customerMenu();
	}

	private void customerMenu() {
		
		boolean running = true;
		while (running) {
			int choice = writeCustomerMenu();
			switch (choice) {
			case 1:
				createCustomer();
				break;
			case 2: 
				 findCustomer();
				break;
			case 3: 
				 updateCustomer();
				break;
			case 4: 
				 removeCustomer();
				break;
			case 5: 
				 printAllCustomers();
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
	
	public int writeCustomerMenu() {
		//TODO Print the TUI Customer menu and return the users choice to be used in CustomerMenu()
		Scanner keyboard = new Scanner(System.in);
		System.out.println("** Kunde Menu **");
		System.out.println(" (1) Opret kunde");
		System.out.println(" (2) Søg kunde");
		System.out.println(" (3) Opdater kunde");
		System.out.println(" (4) slet kunde");
		System.out.println(" (5) Vis alle kunder");
		System.out.println(" (0) Tilbage");
		System.out.println("\n Vælg");
		int choice = getIntegerFromUser(keyboard);
		return choice; 
	}
	
	private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        int i = keyboard.nextInt();
        keyboard.nextLine();
        return i;
	}
	
	public void createCustomer() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Indtast navn på kunden: ");
		String name = keyboard.nextLine();
		
		System.out.println("Indtast email på kunden: ");
		String email = keyboard.nextLine();
		
		System.out.println("Indtast Tlf nummer på kunden: ");
		String phoneNr = String.valueOf(getIntegerFromUser(keyboard));
		
		System.out.println("Indtast adresse på kunden: ");
		String address = keyboard.nextLine();
		
		Customer c = cc.createCustomer(name, email, phoneNr, address);
		
		if(c != null) {
			System.out.println(c.getName() + " Er oprettet.");
		} 
		
	}
	
	public void findCustomer() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Indtast kunde ID: ");
		String customerID = String.valueOf(getIntegerFromUser(keyboard));
		
		Customer c = cc.inputCustomerID(customerID);
		if(c != null) {
			printCustomerInfo(c);
		} else {
			System.out.println("Kunden findes ikke.");
		}
	}
	
	public void printCustomerInfo(Customer c) {
		
		System.out.println("*** Kunde info ***");
		System.out.println("Navn: " + c.getName());
		System.out.println("Email: " + c.getEmail());
		System.out.println("Tlf nummer: " + c.getPhoneNr());
		System.out.println("Adresse: " + c.getAddress());
		
		if(c.getCustomerCategory() != null) {
		System.out.println("Kunde kategori: " + c.getCustomerCategory().getName());
		}
		
	}
	
	public void updateCustomer() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Indtast kunde ID: ");
		String customerID = String.valueOf(getIntegerFromUser(keyboard));
		
		Customer c = cc.inputCustomerID(customerID);
		
		if(c != null) {
		
			System.out.println("Indtast nyt navn på kunden: ");
			String name = keyboard.nextLine();
			
			System.out.println("Indtast ny email på kunden: ");
			String email = keyboard.nextLine();
			
			System.out.println("Indtast nyt Tlf nummer på kunden: ");
			String phoneNr = String.valueOf(getIntegerFromUser(keyboard));
			
			System.out.println("Indtast ny adresse på kunden: ");
			String address = keyboard.nextLine();
			
			cc.updateCustomer(customerID, name, email, phoneNr, address);
			
			System.out.println("Kunde oplysningerne er blevet opdateret");
		} else {
			System.out.println("Kunden findes ikke.");
		}
	}
	
	public void removeCustomer() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Indtast kunde ID: ");
		String customerID = String.valueOf(getIntegerFromUser(keyboard));
		
		if(cc.removeCustomerByID(customerID)) {
			System.out.println("Kunde slettet.");
		} else {
			System.out.println("Kunden findes ikke.");
		}
		
	}
	
	public void printAllCustomers() {
		
		for(Customer c : cc.printAllCustomers()) {
			printCustomerInfo(c);
			System.out.println();
		}
	}
	
}
