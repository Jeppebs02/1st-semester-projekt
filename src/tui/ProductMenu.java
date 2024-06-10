package tui;

import java.util.Scanner;

import control.ProductController;
import model.Customer;
import model.ItemPrice;
import model.Location;
import model.Product;

public class ProductMenu {

	private ProductController pc;
	
	public ProductMenu() {
		pc = new ProductController();
	}
	
	public void start() {
		productMenu();
	}
	
	private void productMenu() {
		
		boolean running = true;
		while (running) {
			int choice = writeProductMenu();
			switch (choice) {
			case 1:
				createProduct();
				break;
			case 2: 
				findProduct();
				break;
			case 3: 
				
				break;
			case 4: 
				
				break;
			case 5: 
				
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
	
	public int writeProductMenu() {
		//TODO Print the TUI Customer menu and return the users choice to be used in CustomerMenu()
		Scanner keyboard = new Scanner(System.in);
		System.out.println("** Produkt Menu **");
		System.out.println(" (1) Opret produkt");
		System.out.println(" (2) Søg produkt");
		//System.out.println(" (3) Opdater produkt");
		//System.out.println(" (4) slet produkt");
		//System.out.println(" (5) Vis alle produkter");
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
	
	public void createProduct() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Indtast stregkode på produktet: ");
		String barcode = keyboard.nextLine();
		
		System.out.println("Indtast navn på produktet: ");
		String name = keyboard.nextLine();
		
		System.out.println("Indtast en beskrivelse af produktet: ");
		String description = keyboard.nextLine();
		
		System.out.println("Indtast SKU nummer: ");
		String sKU = keyboard.nextLine();
		
		System.out.println("Indtast kategori: ");
		String category = keyboard.nextLine();
		
		System.out.println("Indtast indkøbspris: ");
		double costPrice = Double.valueOf(getIntegerFromUser(keyboard));
		
		System.out.println("Indtast vejl. salgspris: ");
		double MSRP = Double.valueOf(getIntegerFromUser(keyboard));
		
		System.out.println("Indtast salgspris: ");
		double salesPrice = Double.valueOf(getIntegerFromUser(keyboard));
		
		System.out.println("Indtast rabat: ");
		double discount = Double.valueOf(getIntegerFromUser(keyboard));
		
		//Må man godt oprette et opjekt fra UI laget?? - Kasper
		ItemPrice ip = new ItemPrice(costPrice, MSRP, salesPrice, discount);
		
		System.out.println("Indtast varehus: ");
		String department = keyboard.nextLine();
		
		System.out.println("Indtast række: ");
		String aisle = String.valueOf(getIntegerFromUser(keyboard));

		System.out.println("Indtast hylde: ");
		String shelf = String.valueOf(getIntegerFromUser(keyboard));
		
		System.out.println("Indtast minimum beholdning: ");
		int minStock = getIntegerFromUser(keyboard);
		
		System.out.println("Indtast maximum beholdning: ");
		int maxStock = getIntegerFromUser(keyboard);
		
		System.out.println("Indtast antal der ligges på lager: ");
		int stock = getIntegerFromUser(keyboard);
		
		//Må man godt oprette et opjekt fra UI laget?? - Kasper
		Location l = new Location(department, aisle, shelf, minStock, maxStock, stock);
		
		Product p = pc.createProduct(name, barcode, description, sKU, category, ip, l);
		
		if(p != null) {
			System.out.println(p.getName() + " er oprettet.");
		}
	}
	
	public void findProduct() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Indtast Stregkode på produkt: ");
		String barcode = String.valueOf(getIntegerFromUser(keyboard));
		
		Product p = pc.inputProduct(barcode);
		if(p != null) {
			printProductInfo(p);
		} else {
			System.out.println("Produktet findes ikke.");
		}
	}
	
	public void printProductInfo(Product p) {
		
		System.out.println("*** Produkt info ***");
		System.out.println("Navn: " + p.getName());
		System.out.println("Stregkode: " + p.getBarcode());
		System.out.println("Beskrivelse: " + p.getDescription());
		System.out.println("SKU nummer: " + p.getSKU());
		System.out.println("Kategori: " + p.getCategory());
		System.out.println("Pris: " + p.getPrice().getSalesPrice());
		System.out.println("Lokation: " + p.getInventory().getDepartment());
		System.out.println(p.getInventory().getAisle() + ", " + p.getInventory().getShelf());

		}
		
	
	
	
	
	
	
	
	
	
}
