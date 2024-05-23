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

	public Product findProductByBarcode(String barcode) {
		Product foundProduct = null;
		Product currentProduct = null;
		boolean searching = true;
		Iterator<Product> iterator = products.iterator();

		while (searching && iterator.hasNext()) {
			currentProduct = iterator.next();
			if (currentProduct.getBarcode().equals(barcode)) {
				foundProduct = currentProduct;
				searching = false;
			}
		}
		return foundProduct;
		
	}

}
