package control;

import java.util.ArrayList;

import model.Customer;
import model.CustomerContainer;
import model.ItemPrice;
import model.Location;
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
	
	public boolean deleteProduct(String barcode) {
		Product p = inputProduct(barcode);
		return ProductContainer.getInstance().removeProduct(p);
	}
	
	public Product createProduct(String name, String barcode, String description, String sKU, String category, ItemPrice price,
			Location inventory) {
		
		Product p = new Product(name, barcode, description, sKU, category, price, inventory);
		ProductContainer.getInstance().addProductsToContainer(p);
		return p;
		
	}
	
	public void updateProduct(String barcode, String name, String description, String sKU, String Category, ItemPrice price, Location inventory) {
		Product p = inputProduct(barcode);
		
		p.setName(name);
		p.setDescription(description);
		p.setSKU(sKU);
		p.setCategory(Category);
		p.setPrice(price);
		p.setInventory(inventory);
		
	}
	
	public ArrayList<Product> printAllProducts(){
		return ProductContainer.getInstance().findAllProducts();
	}
	
	public ArrayList<Product> getProductsByDescription(String description) {
		ProductContainer pc = ProductContainer.getInstance();
		return pc.findProductsByDescription(description);
	}
	
	public ArrayList<Product> getProductsByCategory(String category) {
		ProductContainer pc = ProductContainer.getInstance();
		return pc.findProductsByCategory(category);
	}
	
	public ArrayList<Product> getProductsByName(String name){
		ProductContainer pc = ProductContainer.getInstance();
		return pc.findProductsByName(name);
	}
}
