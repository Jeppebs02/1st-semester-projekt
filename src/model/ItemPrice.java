package model;

import java.time.LocalDateTime;

public class ItemPrice {
	private double costPrice;
	private double MSRP;
	private double salesPrice;
	private double discount;
	private LocalDateTime date;

	
	
	public ItemPrice(double costPrice, double mSRP, double salesPrice, double discount) {
		super();
		this.costPrice = costPrice;
		MSRP = mSRP;
		this.discount = discount;
		this.salesPrice = salesPrice*discount;
		this.date = LocalDateTime.now();
	}


	public double getSalesPrice() throws NullPointerException {
		if (salesPrice < 0) {
			throw new IllegalArgumentException("salesprice cant be less than 0");
		}
		return salesPrice;
	}
	
	



}
