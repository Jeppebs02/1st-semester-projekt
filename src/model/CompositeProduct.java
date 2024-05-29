package model;

import java.util.ArrayList;
import model.CompositeLine;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class holds information needed to create 
//products consisting of other products in the system. 
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
		return super.getBarcode();
	}
	
	public void addComponent(CompositeLine component) throws IllegalArgumentException {
		if(component == null) {
			throw new IllegalArgumentException("component is null");
		}
		components.add(component);
	}
	
	

}
