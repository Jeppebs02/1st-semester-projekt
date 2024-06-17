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
    private ArrayList<OrderLine> orderLines; 

	public OrderTableModel(OrderController orderController) {
    	oc = orderController;
    	orderLines = oc.getOrderLines();

    }
    
    public OrderTableModel() {
    	OrderController oc = new OrderController();
    	orderLines = new ArrayList<>();
    }
    
    public void initSearchOrder() {
    	orderLines = oc.getOrderLines();
    }
    
	@Override
	public int getRowCount() {
		return orderLines.size();
	}
	
	public int getSearchRowCount() {
		return orderLines.size();
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
			returnString = orderLines.get(r).getProduct().getName();
		} else if (c==1) {
			returnString = "" + orderLines.get(r).getQuantity();
		} else if (c==2) {
			returnString = "" + (orderLines.get(r).getProduct().getPrice().getSalesPrice() * orderLines.get(r).getQuantity());
		}
		return returnString;
	}

	public ArrayList<OrderLine> getSearchOrderLines() {
		return orderLines;
	}

    public void setSearchOrderLines(ArrayList<OrderLine> searchOrderLines) {
		this.orderLines = searchOrderLines;
	}    
}
