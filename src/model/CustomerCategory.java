package model;

public class CustomerCategory {
	private String name;
	private String description;
	private double discount;

	

	public CustomerCategory(String name, String description, double discount) {
		super();
		this.name = name;
		this.description = description;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	

}
