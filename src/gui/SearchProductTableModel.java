package gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.table.AbstractTableModel;

import control.ProductController;
import model.Product;

public class SearchProductTableModel extends AbstractTableModel {
	
	private final String[] COLUMN_NAMES = {"Navn", "Kategori", "SKU", "Streg kode", "Pris", "Afdeling", "Række", "Hylde", "Antal på lager","Beskrivels"};
	private ProductController pc;
	private ArrayList<Product> products;
	
	public SearchProductTableModel () {
		pc = new ProductController();
		products = new ArrayList<>();
	}
	
	public void initProductTable () {
		products = pc.printAllProducts();
		Collections.sort(products, new Comparator<Product>() {
            public int compare(Product product1, Product product2) {
                return product1.getName().compareToIgnoreCase(product2.getName());
            }
        });
	}
	
	public void sortProductTableByName () {
		Collections.sort(products, new Comparator<Product>() {
            public int compare(Product product1, Product product2) {
                return product1.getName().compareToIgnoreCase(product2.getName());
            }
        });
	}
	
	@Override
	public int getRowCount() {
		return products.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	@Override
	public Object getValueAt(int r, int c) {
		String returnString = "";
		
		if (c==0) {
			returnString = products.get(r).getName();
		} else if (c==1) {
			returnString = products.get(r).getCategory();
		} else if (c==2) {
			returnString = products.get(r).getSKU();
		} else if (c==3) {
			returnString = products.get(r).getBarcode();
		} else if (c==4) {
			returnString = "" + products.get(r).getPrice().getSalesPrice();
		} else if (c==5) {
			returnString = products.get(r).getInventory().getDepartment();
		} else if (c==6) {
			returnString = products.get(r).getInventory().getAisle();
		} else if (c==7) {
			returnString = products.get(r).getInventory().getShelf();
		} else if (c==8) {
			returnString = "" + products.get(r).getInventory().getStock();
		} else if (c==9) {
			returnString = products.get(r).getDescription();
		} 
		return returnString;
	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}
	
	public ArrayList<Product> getProoducts() {
		return products;
	}
	
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public Product getSelectedProduct (int r) {
		return products.get(r);
	}
}
