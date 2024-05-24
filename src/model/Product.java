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


	public String getBarcode() {
		return barcode;
	}


	public String getName() {
		return name;
	}


	public ItemPrice getPrice() {
		return price;
	}
	
	


}
