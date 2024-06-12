package gui;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

import control.OrderController;
import model.Order;
import model.OrderLine;

public class OrderTableModel extends AbstractTableModel {
    private final String[] COLUMN_NAMES = {"Produkt", "Antal", "Pris"};
    private OrderController oc;
    private ArrayList<Order> orderList; 

    public OrderTableModel() {
    	//TODO hent controller fra CreateOffer
    	oc = new OrderController();
    	orderList = oc.getOrderList();
    }

	@Override
	public int getRowCount() {
		return orderList.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	@Override
	public Object getValueAt(int r, int c) {
		String returnString = ""; 
		if (c==0) {
			
		} else if (c==1) {
			
		} else if (c==2) {
			
		}
		return returnString;
	}
    
    
}
