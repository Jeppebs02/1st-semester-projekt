package model;

public class Location {
	private String department;
	private String aisle;
	private String shelf;
	private int minStock;
	private int maxStock;
	private int stock;
	
	public Location(String department, String aisle, String shelf, int minStock, int maxStock, int stock) {
		super();
		this.department = department;
		this.aisle = aisle;
		this.shelf = shelf;
		this.minStock = minStock;
		this.maxStock = maxStock;
	}
	
	


}
