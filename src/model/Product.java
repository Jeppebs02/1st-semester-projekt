package model;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: this class holds the object that is a product.
public class Product {
	
	private String name;
	private String barcode;
	private String description;
	private String SKU;
	private String category;
	private ItemPrice price;
	private Location inventory;
	
	public Product(String name, String barcode, String description, String sKU, String category, ItemPrice price,
			Location inventory) {
		super();
		this.name = name;
		this.barcode = barcode;
		this.description = description;
		SKU = sKU;
		this.category = category;
		this.price = price;
		this.inventory = inventory;
	}


	public String getBarcode() throws NullPointerException {
		if (barcode == null) {
			throw new NullPointerException("Barcode cant be Null");
		}
		return barcode;
	}


	public String getName() throws NullPointerException {
		if (name == null) {
			throw new NullPointerException("Product name cant be Null");
		}
		return name;
	}


	public ItemPrice getPrice() throws NullPointerException {
		if (price == null) {
			throw new NullPointerException("itemPrice cant be Null");
		}
		return price;
	}


	public Location getInventory() throws NullPointerException {
		if (price == null) {
			throw new NullPointerException("Inventory cant be Null");
		}
		return inventory;
	}
	
	


}
