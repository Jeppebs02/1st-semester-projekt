package model;
import model.CompositeProduct;
import model.Product;

public class CompositeLine {
	private int quantity;
	private Product product;
	
	public CompositeLine (int quantity, Product product) {
		this.quantity = quantity;
		this.product = product; 
	}
}

