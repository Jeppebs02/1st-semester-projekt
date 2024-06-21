package model;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class holds information about a customers category.
public class CustomerCategory {
	private String name;
	private String description;
	private double discount;
	private int paymentDeadline;

	
	public CustomerCategory(String name, String description, double discount, int paymentDeadline) {
		super();
		this.name = name;
		this.description = description;
		this.discount = discount;
		this.paymentDeadline = paymentDeadline;
	}

	public String getName() throws NullPointerException {
		if (name == null) {
			throw new NullPointerException("Category name cant be Null");
		}
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
		if (name.equals("")) {
			throw new IllegalArgumentException("Name cant be Null");
		} if (name.equals(" ")) {
			throw new IllegalArgumentException("Name cant be an empt space");
		} 
		this.name = name;
	}

	public String getDescription() throws NullPointerException {
		if (name == null) {
			throw new NullPointerException("Description cant be Null");
		}
		return description;
	}

	public void setDescription(String description) throws IllegalArgumentException {
		if (description.equals("")) {
			throw new IllegalArgumentException("description cant be Null");
		} if (description.equals(" ")) {
			throw new IllegalArgumentException("description cant be an empt space");
		} 
		this.description = description;
	}

	public double getDiscount() throws NullPointerException {
		if (discount < 0) {
			throw new NullPointerException("Customer Discount cant be less than 0. Discount is expressed as a decimal nr. No discount is 1, 20% discount is 0,8, 50% discount is 0,5");
		}
		return discount;
	}

	public void setDiscount(double discount) throws IllegalArgumentException {
		if (discount < 0) {
			throw new IllegalArgumentException("Discount cant be less than or zero. Discount is expressed as a decimal nr. no discount is 1, 20% discount is 0,8, 50% discount is 0,5");
		}
		this.discount = discount;
	}
	
	public int getPaymentDeadline() {
		return paymentDeadline;
	}

	public double calculateDiscountPercent() {
		double discountPercent;
		
		discountPercent = (1 - discount) * 100;
		
		return Math.ceil(discountPercent);
	}
	
}
