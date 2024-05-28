package model;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class holds a quantity and a product compiled in 
//a orderline.
public class OrderLine {
	private int quantity;
	private Product product;
	
	
	public OrderLine(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}
	
	public double calculateOrderLinePrice() {
		
		return product.getPrice().getSalesPrice()*quantity;
	}


	public int getQuantity() throws NullPointerException {
		if (quantity < 1) {
		throw new NullPointerException("Quantity cant be less than 1");
		}
		return quantity;
	}


	public void setQuantity(int quantity) throws IllegalArgumentException {
		if (quantity < 1) {
		throw new IllegalArgumentException("Quantity cant be less than 1");
		}
		
		this.quantity = quantity;
	}


	public Product getProduct() throws NullPointerException {
		if (product == null) {
		throw new NullPointerException("Product cant be Null");
		}
		return product;
	}


	public void setProduct(Product product) throws IllegalArgumentException {
		if(product == null) {
			throw new IllegalArgumentException("Product cannot be null");
		}
		this.product = product;
	}
	
	
	

}
