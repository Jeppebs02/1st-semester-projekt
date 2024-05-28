package model;

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
			throw new IllegalArgumentException("Barcode cant be Null");
		}
		return barcode;
	}


	public String getName() throws NullPointerException {
		if (name == null) {
			throw new IllegalArgumentException("Product name cant be Null");
		}
		return name;
	}


	public ItemPrice getPrice() throws NullPointerException {
		if (price == null) {
			throw new IllegalArgumentException("itemPrice cant be Null");
		}
		return price;
	}


	public Location getInventory() {
		return inventory;
	}
	
	


}
