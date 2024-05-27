package tui;

import model.*;

public class TryMe {

	
	public static void addData() {
		
		LoginContainer lc = LoginContainer.getInstance();
		ProductContainer pc = ProductContainer.getInstance();
		CustomerContainer cc = CustomerContainer.getInstance();
		
		
		Customer c = new Customer("Bob Jepsen", "Bob@1337.com", "22112233", "Hurtigvej 99", "22112233");
		cc.addCustomerToContainer(c);
		
		Customer c1 = new Customer("Average Joe", "Average@Joe.com", "44556677", "Average Street 44", "44556677");
		CustomerCategory cuc = new CustomerCategory("Loyal", "Loyale kunder", 0.90, 14);
		c1.setCustomerCategory(cuc);
		cc.addCustomerToContainer(c1);
		
		
		lc.setLoginUser(new Employee("Jeppe", "Jeppebs02@doxed.com", "12341234", "Pågade 22", "ctfjeppebs02", "BestName4ever", "12341234"));
		
		Location l = new Location("DIY store", "Række 34", "Hylde 234", 20, 400, 50);
		ItemPrice ip = new ItemPrice(50, 200, 200, 1);
		pc.addProductsToContainer(new Product("Søm", "66778899", "Søm til træ", "66778899", "Trælast", ip,l));
		
		ItemPrice ip1 = new ItemPrice(20.5, 50, 50, 1);
		Location l1 = new Location("DIY store", "Række 12", "Hylde 222", 10, 30, 14);
		pc.addProductsToContainer(new Product("Hammer", "12345678", "Hammer med træskaft", "12345678", "Værktøj", ip1, l1));

		ItemPrice ip2 = new ItemPrice(75, 150, 150, 1);
		Location l2 = new Location("DIY store", "Række 14", "Hylde 134", 10, 30, 18);
		pc.addProductsToContainer(new Product("Skruetrækker", "87654321", "Skruetrækker sæt", "87654321", "Værktøj", ip2, l2));

		ItemPrice ip3 = new ItemPrice(5, 15, 15, 1);
		Location l3 = new Location("DIY store", "Række 12", "Hylde 334", 40, 100, 66);
		pc.addProductsToContainer(new Product("Målebånd", "11223344", "5 meter målebånd", "11223344", "Måleværktøj", ip3, l3));

		ItemPrice ip4 = new ItemPrice(120, 300, 300, 1);
		Location l4 = new Location("DIY store", "Række 17", "Hylde 534", 5, 20, 8);
		pc.addProductsToContainer(new Product("Boremaskine", "55667788", "Elektrisk boremaskine", "55667788", "Elværktøj", ip4, l4));

		ItemPrice ip5 = new ItemPrice(8, 25, 25, 1);
		Location l5 = new Location("DIY store", "Række 22", "Hylde 214", 30, 500, 65);
		pc.addProductsToContainer(new Product("Møtrikker", "99887766", "Sæt med møtrikker", "99887766", "Fastgørelseselementer", ip5, l5));

		ItemPrice ip6 = new ItemPrice(15, 40, 40, 1);
		Location l6 = new Location("DIY store", "Række 4", "Hylde 444", 40, 800, 77);
		Product p6 = new Product("Skruer", "33445566", "Pakke med skruer", "33445566", "Fastgørelseselementer", ip6, l6);
		pc.addProductsToContainer(p6);

		ItemPrice ip7 = new ItemPrice(35, 100, 100, 1);
		Location l7 = new Location("DIY store", "Række 1", "Hylde 180", 5, 30, 26);
		pc.addProductsToContainer(new Product("Sav", "44556677", "Håndsav", "44556677", "Værktøj", ip7, l7));

		ItemPrice ip8 = new ItemPrice(60, 180, 180, 1);
		Location l8 = new Location("DIY store", "Række 29", "Hylde 274", 10, 50, 26);
		pc.addProductsToContainer(new Product("Vaterpas", "22113344", "Vaterpas 30 cm", "22113344", "Måleværktøj", ip8, l8));

		ItemPrice ip9 = new ItemPrice(25, 60, 60, 1);
		Location l9 = new Location("DIY store", "Række 31", "Hylde 116", 5, 20, 10);
		pc.addProductsToContainer(new Product("Stiksav", "33224455", "Elektrisk stiksav", "33224455", "Elværktøj", ip9, l9));

		ItemPrice ip10 = new ItemPrice(50, 100, 100, 1);
		Location l10 = new Location("DIY store", "Række 49", "Hylde 300", 20, 100, 67);
		Product p10 = new Product("Træ plade", "99008800", "Træ plade af krydsfiner", "99008800", "Trælast", ip10, l10);
		pc.addProductsToContainer(p10);

		ItemPrice ip11 = new ItemPrice(5, 20, 20, 1);
		Location l11 = new Location("DIY store", "Række 32", "Hylde 166", 30, 200, 87);
		Product p11 = new Product("Greb", "77118822", "Håndtag til låger", "77118822", "Beslag", ip11, l11);
		pc.addProductsToContainer(p11);

		
		
		CompositeLine skab1 = new CompositeLine(8, p10);
		CompositeLine skab2 = new CompositeLine(1, p11);
		CompositeLine skab3 = new CompositeLine(1, p6);
		
		ItemPrice ip12 = new ItemPrice(300, 500, 500, 1);
		Location l12 = new Location("DIY store", "Række 60", "Udstilling", 2, 10, 4);
		
		CompositeProduct skab = new CompositeProduct("Skab", "445566", "Køkkenskab", "445566", "Køkken", ip12, l12, "Manual");
		skab.addComponent(skab1);
		skab.addComponent(skab2);
		skab.addComponent(skab3);
		pc.addProductsToContainer(skab);
		
		
	}
	
}
