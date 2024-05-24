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
		if(product.getPrice().getSalesPrice() > 0) {
			throw new IllegalArgumentException("Sales price is set to less than 0");
		}
		if(quantity > 1) {
			throw new IllegalArgumentException("quantity is set to less than 1");
		}
		return product.getPrice().getSalesPrice()*quantity;
	}


	public int getQuantity() throws IllegalArgumentException {
		if(getQuantity() > 1) {
			throw new IllegalArgumentException("quantity is set to less than 1");
		}
		return quantity;
	}


	public void setQuantity(int quantity) throws IllegalArgumentException {
		if(quantity < 1) {
			throw new IllegalArgumentException("Quantity cannot be less than 1");
		}
		this.quantity = quantity;
	}


	public Product getProduct() throws NullPointerException {
		if(getProduct() == null) {
			throw new NullPointerException("Product is null");
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
