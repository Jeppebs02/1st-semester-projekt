package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductContainer {
	private ArrayList<Product> products;
	private static ProductContainer instance;
	
	

	private ProductContainer() {
		products= new ArrayList<>();
	}
	
	public static ProductContainer getInstance() {
		if (instance==null) {
			instance = new ProductContainer();
		}
		return instance;
	}

}
