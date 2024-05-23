package model;

import java.time.LocalDate;

public class ItemPrice {
	private double costPrice;
	private double MSRP;
	private double salesPrice;
	private double discount;
	private LocalDate date;

	
	
	public ItemPrice(double costPrice, double mSRP, double salesPrice, double discount, LocalDate date) {
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
