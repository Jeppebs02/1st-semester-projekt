package model;

public class OrderLine {
	private int quantity;
	private Product product;
	
	
	public OrderLine(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}
	
	public double calculateOrderLinePrice() throws IllegalArgumentException {
		if(quantity > 1) {
			throw new IllegalArgumentException("quantity is set to less than 1");
		}
		return product.getPrice().getSalesPrice()*quantity;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) throws IllegalArgumentException {
		if(quantity < 1) {
			throw new IllegalArgumentException("Quantity cannot be less than 1");
		}
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
