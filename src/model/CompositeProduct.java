package model;

import java.util.ArrayList;
import model.CompositeLine;

public class CompositeProduct extends Product {

	private String assemblyInstructions;
	private ArrayList<CompositeLine> components;
	

	public CompositeProduct(String name, String barcode, String description, String sKU, String category,
			ItemPrice price, Location iventory, String assemblyInstructions, ArrayList<CompositeLine> components) {
		super(name, barcode, description, sKU, category, price, iventory);
		this.assemblyInstructions = assemblyInstructions;
		this.components = components;
	}
	
	public String getBarcode() {
		return super.getBarcode();
	}
	
	public void addComponent(CompositeLine component) {
		components.add(component);
	}
	
	

}
