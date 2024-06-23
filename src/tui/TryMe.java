package tui;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import control.OrderController;
import model.*;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class contains all our testdata.
public class TryMe {

	
	public static void addData() {
		
		LoginContainer lc = LoginContainer.getInstance();
		ProductContainer pc = ProductContainer.getInstance();
		CustomerContainer cc = CustomerContainer.getInstance();
		OrderController oc = new OrderController();
		
		
		Customer c = new Customer("Bob Jepsen", "Bob@1337.com", "22112233", "Hurtigvej 99", "22112233");
		cc.addCustomerToContainer(c);
		
		Customer c2 = new Customer("Rikke denseje", "mulle273@dinmor.dk", "66699666", "Spurgt 69", "66699666");
		cc.addCustomerToContainer(c2);
		
		
		Customer c1 = new Customer("Average Joe", "Average@Joe.com", "44556677", "Average Street 44", "44556677");
		CustomerCategory cuc = new CustomerCategory("Loyal", "Loyale kunder", 0.90, 14);
		c1.setCustomerCategory(cuc);
		cc.addCustomerToContainer(c1);
		c2.setCustomerCategory(cuc);
		
		// Opret kundekategorier
        CustomerCategory loyalCategory = new CustomerCategory("Loyal", "Loyale kunder", 0.90, 14);
        CustomerCategory newCustomerCategory = new CustomerCategory("Ny", "Nye kunder", 1.0, 7);
        CustomerCategory vipCustomerCategory = new CustomerCategory("VIP", "VIP kunder", 0.85, 30);
        CustomerCategory frequentBuyerCategory = new CustomerCategory("Hyppig", "Hyppige købere", 0.95, 7);

		
		
		// Liste med tilfældige navne
        List<String> firstNames = Arrays.asList("Anna", "Bent", "Carl", "Ditte", "Emil", "Freja", "Gustav", "Hanne", "Ivan", "Jette", 
        	    "Kasper", "Lone", "Mads", "Nina", "Ole", "Pia", "Rasmus", "Sara", "Tina", "Uffe", 
        	    "Vera", "William", "Xenia", "Yvonne", "Zack", "Astrid", "Bjarke", "Cecilie", "David", "Ellen", 
        	    "Flemming", "Gitte", "Henrik", "Iben", "Jens", "Kirsten", "Lars", "Maria", "Nikolaj", "Oda", 
        	    "Pernille", "Rikke", "Søren", "Tove", "Ulla", "Viggo", "Winnie", "Yngve", "Åse", "Aksel", 
        	    "Birgit", "Claus", "Dorte", "Erik", "Frida", "Grethe", "Holger", "Ingrid", "Johannes", "Karen", 
        	    "Lise", "Morten", "Niels", "Otto", "Per", "Ruth", "Susanne", "Torben", "Vibeke", "Willy", 
        	    "Ane", "Bo", "Christina", "Dennis", "Eva", "Finn", "Gorm", "Helle", "Ib", "Johan", 
        	    "Katrine", "Leif", "Maja", "Naja", "Oskar", "Palle", "Ronja", "Sigurd", "Trine", "Viktor", 
        	    "Wendy", "Yasmin", "Ziggy", "Anton", "Birthe", "Camilla", "Dagmar", "Edith", "Frederik", "Gunnar");
        
        List<String> lastNames = Arrays.asList( "Andersen", "Bach", "Christensen", "Dam", "Eriksen", "Frederiksen", "Gade", "Hansen", "Iversen", "Jensen", 
        	    "Kjær", "Larsen", "Møller", "Nielsen", "Olsen", "Pedersen", "Rasmussen", "Schmidt", "Thomsen", "Ullerup", 
        	    "Villadsen", "Westergaard", "Xavi", "Yder", "Ziegler", "Aagaard", "Bang", "Brodersen", "Christoffersen", "Dalsgaard", 
        	    "Due", "Enevoldsen", "Fischer", "Foged", "Gustavsen", "Hedegaard", "Holm", "Isaksen", "Juul", "Kirkegaard", 
        	    "Lind", "Lund", "Mathiesen", "Nyborg", "Overgaard", "Poulsen", "Quist", "Riis", "Skov", "Storm", 
        	    "Toft", "Ulriksen", "Vad", "Wulff", "Østergaard", "Ågård", "Bech", "Berg", "Bertelsen", "Bisgaard", 
        	    "Boesen", "Brandt", "Bryld", "Bøgh", "Carlsen", "Dahl", "Dyhr", "Frost", "Hede", "Hoffmann", 
        	    "Hougaard", "Hyldgaard", "Juhl", "Koch", "Kragh", "Krogh", "Lauridsen", "Lundgaard", "Lykke", "Madsen", 
        	    "Markussen", "Michelsen", "Munk", "Normann", "Nørgaard", "Pilgaard", "Sander", "Skaarup", "Strand", "Sørensen", 
        	    "Terkelsen", "Thuesen", "Thygesen", "Vedel", "Vestergaard", "Vinding", "Winther", "Witt", "Ødum", "Østergård");
       
        String[] streetNames = {
        	    "Adelgade", "Bakkegårdsvej", "Borups Allé", "Christianshavns Voldgade", "Dag Hammarskjölds Allé", 
        	    "Elmegade", "Frederiksgade", "Gammel Kongevej", "H.C. Andersens Boulevard", "Istedgade",
        	    "Jagtvej", "Kongens Nytorv", "Langebrogade", "Mølle Allé", "Nørrebrogade",
        	    "Østerbrogade", "Pilestræde", "Rantzausgade", "Sankt Annæ Plads", "Strandvejen",
        	    "Teglgårdsstræde", "Uplandsgade", "Vesterbrogade", "Wildersgade", "Yderlandsvej",
        	    "Zahle Allé", "Åboulevard", "Amagerbrogade", "Bredgade", "Classensgade",
        	    "Drechselsgade", "Enghavevej", "Finsensvej", "Gothersgade", "Herman Bangs Plads",
        	    "Ingerslevsgade", "Kastelvej", "Lygten", "Nansensgade", "Rosenørns Allé"
        	};

        Random rand = new Random();

        // Tilføj 999 kunder
        for (int i = 1; i <= 999; i++) {
            String firstName = firstNames.get(rand.nextInt(firstNames.size()));
            String lastName = lastNames.get(rand.nextInt(lastNames.size()));
            String streetName = streetNames[rand.nextInt(streetNames.length)];
            String phoneNumber = String.format("12345%03d", i);
            Customer customer = new Customer(firstName + " " + lastName, firstName.toLowerCase() + i + "@gmail.com", phoneNumber, streetName + " " + i, phoneNumber);

            if (i % 5 == 0) {
                customer.setCustomerCategory(loyalCategory);
            } else if (i % 5 == 1) {
                customer.setCustomerCategory(newCustomerCategory);
            } else if (i % 5 == 2) {
                customer.setCustomerCategory(vipCustomerCategory);
            } else if (i % 5 == 3) {
                customer.setCustomerCategory(frequentBuyerCategory);
            } else if (i % 5 == 4) {
                customer.setCustomerCategory(loyalCategory);
            }
            cc.addCustomerToContainer(customer);
        }
		
		
		Employee admin = new Employee("Admin", "Admin@Admin.com", "66666666", "Admin Street 666", "Admin", "Admin", "Admin");
		Employee jeppe = new Employee("Jeppe", "Jeppebs02@doxed.com", "12341234", "Pågade 22", "ctfjeppebs02", "BestName4ever", "12341234");
		lc.addNewEmployee(jeppe);
		lc.addNewEmployee(admin);
		
		lc.setLoginUser(jeppe);
		
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
		
		
		//ordre nr1
		oc.createOffer();
		oc.inputProduct("12345678", 4);
		oc.inputCustomerID("44556677");
		String ordreNr = oc.generateOrderNr();
		oc.saveOffer(ordreNr);
		
		//ordre nr2
		oc.createOffer();
		oc.inputProduct("445566", 2);
		oc.inputProduct("66778899", 20);
		oc.inputCustomerID("44556677");
		ordreNr = oc.generateOrderNr();
		oc.saveOffer(ordreNr);
		
		// ordre nr3
        oc.createOffer();
        oc.inputProduct("55667788", 1); // Boremaskine, max 8
        oc.inputProduct("99887766", 10); // Møtrikker, max 65
        oc.inputProduct("11223344", 10); // Målebånd, max 66
        oc.inputCustomerID("66699666");
        ordreNr = oc.generateOrderNr();
        oc.saveOffer(ordreNr);

        // ordre nr4
        oc.createOffer();
        oc.inputProduct("33445566", 5); // Skruer, max 77
        oc.inputProduct("11223344", 10); // Målebånd, max 66
        oc.inputProduct("99008800", 5); // Træ plade, max 67
        oc.inputCustomerID("22112233");
        ordreNr = oc.generateOrderNr();
        oc.saveOffer(ordreNr);

        // ordre nr5
        oc.createOffer();
        oc.inputProduct("44556677", 1); // Sav, max 26
        oc.inputProduct("77118822", 15); // Greb, max 87
        oc.inputProduct("99008800", 5); // Træ plade, max 67
        oc.inputCustomerID("66699666");
        ordreNr = oc.generateOrderNr();
        oc.saveOffer(ordreNr);

        // ordre nr6
        oc.createOffer();
        oc.inputProduct("99008800", 5); // Træ plade, max 67
        oc.inputProduct("33224455", 2); // Stiksav, max 10
        oc.inputCustomerID("44556677");
        ordreNr = oc.generateOrderNr();
        oc.saveOffer(ordreNr);

        // ordre nr7
        oc.createOffer();
        oc.inputProduct("22113344", 3); // Vaterpas, max 26
        oc.inputProduct("87654321", 4); // Skruetrækker, max 18
        oc.inputProduct("33224455", 2); // Stiksav, max 10
        oc.inputProduct("11223344", 10); // Målebånd, max 66
        oc.inputProduct("99008800", 5); // Træ plade, max 67
        oc.inputCustomerID("66699666");
        ordreNr = oc.generateOrderNr();
        oc.saveOffer(ordreNr);
	}
	
}
