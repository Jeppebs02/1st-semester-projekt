package model;

import java.util.ArrayList;

public class SpecificProduct extends Product {
	
	private String modelNr;
	private ArrayList<Copy> copies;
	
	public SpecificProduct(String modelNr ,String name, String barcode, String description, String sKU, String category,
			ItemPrice price, Location inventory) {
		super(name, barcode, description, sKU, category, price, inventory);
		copies = new ArrayList<>();
		
	}
	
	public String getBarcode() throws NullPointerException {
		if(getBarcode() == null) {
			throw new NullPointerException("Customer cannot be null");
		}
		return super.getBarcode();
	}
	
}
