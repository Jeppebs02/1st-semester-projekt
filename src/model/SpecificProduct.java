package model;

import java.util.ArrayList;

//	@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//	@date: 31/5/2024
//  @description: Specific product handles products like fridges
public class SpecificProduct extends Product {
	
	private String modelNr;
	private ArrayList<Copy> copies;
	
	public SpecificProduct(String modelNr ,String name, String barcode, String description, String sKU, String category,
			ItemPrice price, Location inventory) {
		super(name, barcode, description, sKU, category, price, inventory);
		copies = new ArrayList<>();
		
	}
	
	public String getBarcode() {
		return super.getBarcode();
	}
	
}
