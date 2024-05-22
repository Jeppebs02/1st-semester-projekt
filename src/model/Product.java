package model;

public class Product {
	
	private String name;
	private String barcode;
	private String description;
	private String SKU;
	private String category;
	private ItemPrice price;
	private Location iventory;
	
	

	public Product(String name, String barcode, String description, String sKU, String category, ItemPrice price,
			Location iventory) {
		super();
		this.name = name;
		this.barcode = barcode;
		this.description = description;
		SKU = sKU;
		this.category = category;
		this.price = price;
		this.iventory = iventory;
	}


	public String getBarcode() {
		return barcode;
	}


}
