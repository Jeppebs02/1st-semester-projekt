package control;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class contains the ProductController, 
//enabling userinput from the TUI level to interact with the modellayer, 
//without compromising the architecture. 
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
