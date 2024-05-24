package model;

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


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) throws IllegalArgumentException {
		if(product == null) {
			throw new IllegalArgumentException("Product cannot be null");
		}
		this.product = product;
	}
	
	
	

}
