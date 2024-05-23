package control;

import model.Product;
import model.ProductContainer;

public class ProductController {
	private Product currentProduct;
	

	public ProductController() {
		
	}
	
	public Product inputProduct(String barcode) {
		ProductContainer pc = ProductContainer.getInstance();
		return pc.findProductByBarcode(barcode);
	}
	
	
}
