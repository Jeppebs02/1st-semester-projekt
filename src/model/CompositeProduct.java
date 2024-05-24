package model;

import java.util.ArrayList;
import model.CompositeLine;

public class CompositeProduct extends Product {

	private String assemblyInstructions;
	private ArrayList<CompositeLine> components;
	

	public CompositeProduct(String name, String barcode, String description, String sKU, String category,
			ItemPrice price, Location iventory, String assemblyInstructions) {
		super(name, barcode, description, sKU, category, price, iventory);
		this.assemblyInstructions = assemblyInstructions;
		components = new ArrayList<>();
	}
	
	public String getBarcode() {
		if(getBarcode() == null) {
			throw new NullPointerException("Barcode is null -check the product");
		}
		return super.getBarcode();
	}
	
	public void addComponent(CompositeLine component) {
		if(component == null) {
			throw new IllegalArgumentException("component is null");
		}
		components.add(component);
	}
	
	

}
