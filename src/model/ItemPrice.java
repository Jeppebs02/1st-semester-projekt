package model;

import java.time.LocalDateTime;

public class ItemPrice {
	private double costPrice;
	private double MSRP;
	private double salesPrice;
	private double discount;
	private LocalDateTime date;

	
	
	public ItemPrice(double costPrice, double mSRP, double salesPrice, double discount, LocalDateTime date) {
		super();
		this.costPrice = costPrice;
		MSRP = mSRP;
		this.salesPrice = salesPrice*discount;
		this.discount = discount;
		this.date = date;
	}


	public double getSalesPrice() {
		return salesPrice;
	}
	
	



}
