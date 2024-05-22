package model;

public class Location {
	private String department;
	private String aisle;
	private String shelf;
	private int minStock;
	private int maxStock;

	
	
	public Location(String department, String aisle, String shelf, int minStock, int maxStock) {
		super();
		this.department = department;
		this.aisle = aisle;
		this.shelf = shelf;
		this.minStock = minStock;
		this.maxStock = maxStock;
	}
	
	


}
