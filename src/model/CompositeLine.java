package model;
import model.CompositeProduct;
import model.Product;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class holds information about quantity of a product, 
//compiled in a single line for composite products.
public class CompositeLine {
	private int quantity;
	private Product product;
	
	public CompositeLine (int quantity, Product product) {
		this.quantity = quantity;
		this.product = product; 
	}
}

