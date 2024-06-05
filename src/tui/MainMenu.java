package tui;

import java.util.Scanner;

public class MainMenu {
	
	private CustomerMenu cm;
	private OrderMenu om;
	
	public MainMenu() {
		cm = new CustomerMenu();
		om = new OrderMenu();
	}
	
	public void start() {
		mainMenu();
	}

	private void mainMenu() {
		
		boolean running = true;
		while (running) {
			int choice = writeMainMenu();
			switch (choice) {
			case 1:
				cm.start();
				break;
			case 2: 
				 om.start();
				break;
			case 3: 
				 
				break;
			case 4: 
				 
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

	public int writeMainMenu() {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("** Main Menu **");
		System.out.println(" (1) Kunde menu");
		System.out.println(" (2) Ordre Menu");

		System.out.println(" (0) Luk Menu");
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
}
