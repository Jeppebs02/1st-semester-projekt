package gui;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

import control.OrderController;

public class OrderTableModel extends AbstractTableModel {
    private String[] columnNames = {"Produkt", "Antal", "Pris"};
    private OrderController oc;
    

    public OrderTableModel() {
        this.orderLines = new ArrayList<>();
    }

    public void addOrderLine(OrderLine orderLine) {
        this.orderLines.add(orderLine);
        fireTableRowsInserted(orderLines.size() - 1, orderLines.size() - 1);
    }

    @Override
    public int getRowCount() {
        return orderLines.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderLine orderLine = orderLines.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return orderLine.getProduct();
            case 1:
                return orderLine.getQuantity();
            case 2:
                return orderLine.getTotalPrice();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1; // Kun "Antal" kolonnen er redigerbar
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 1) {
            try {
                int newQuantity = Integer.parseInt(aValue.toString());
                if (newQuantity > 0) {
                    OrderLine orderLine = orderLines.get(rowIndex);
                    orderLine.setQuantity(newQuantity);
                    fireTableCellUpdated(rowIndex, 1);
                    fireTableCellUpdated(rowIndex, 2); // Også opdater pris kolonnen
                }
            } catch (NumberFormatException e) {
                // Håndter undtagelsen (f.eks. vis en fejlmeddelelse)
                System.err.println("Invalid number format: " + aValue);
            }
        }
    }
}
