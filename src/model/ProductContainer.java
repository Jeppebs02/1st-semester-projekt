package model;

import java.util.ArrayList;
import java.util.Iterator;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: ProductContainer stores products.
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
	
	public void addProductsToContainer(Product product) throws NullPointerException {
		if(product != null) {
			products.add(product);
		} else {
			throw new NullPointerException("Description cant be Null");
		}
	}

}
