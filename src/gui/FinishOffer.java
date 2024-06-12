package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.OrderController;
import control.OrderStatusController;
import model.Order;
import model.OrderLine;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import javax.swing.JScrollPane;
import java.awt.Choice;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class FinishOffer extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel NorthPane;
	private JLabel lblInputOrderNr;
	private JTextField textOrderNrField;
	private JButton btnSearchOrder;
	private JButton btnOdreNrButton;
	private JLabel lblChangeStatus;
	private JButton btnOpdt;
	private JPanel SouthPane;
	private JButton btnSendInvoice;
	private JButton btnSave;
	private JButton btnBack;
	private JPanel CenterPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel orderLineTableModel ;
	private JPanel panel;
	private JLabel lblDiscount;
	private JLabel lblPrice;
	private Order foundOrder;
	private Choice choice;
	private OrderStatusController osc;
	private String dropDownChoice;
	private JLabel lblCurrentStatus;
	private JLabel lblBlank;
	private GridBagLayout gbl_northPane;
	private GridBagConstraints gbc_textOrderNrField;
	private GridBagConstraints gbc_btnSearchOrder;
	private GridBagConstraints gbc_btnOrderNrButton;
	private GridBagConstraints gbc_lblBlank;
	private GridBagConstraints gbc_lblCurrentStatus;
	private GridBagConstraints gbc_lblChangeStatus;
	private GridBagConstraints gbc_choice;
	private GridBagLayout gbl_panel;
	private GridBagConstraints gbc_lblDiscount;
	private GridBagConstraints gbc_lblPrice;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinishOffer frame = new FinishOffer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FinishOffer() {
		osc = new OrderStatusController();
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		NorthPane = new JPanel();
		contentPane.add(NorthPane, BorderLayout.NORTH);
		gbl_northPane = new GridBagLayout();
		gbl_northPane.columnWidths = new int[]{127, 201, 83, 0};
		gbl_northPane.rowHeights = new int[]{23, 23, 23, 0};
		gbl_northPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_northPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		NorthPane.setLayout(gbl_northPane);
		
		lblInputOrderNr = new JLabel("Indtast ordre nr");
		GridBagConstraints gbc_lblInputOrderNr = new GridBagConstraints();
		gbc_lblInputOrderNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblInputOrderNr.gridx = 0;
		gbc_lblInputOrderNr.gridy = 0;
		NorthPane.add(lblInputOrderNr, gbc_lblInputOrderNr);
		
		textOrderNrField = new JTextField();
		textOrderNrField.setColumns(10);
		gbc_textOrderNrField = new GridBagConstraints();
		gbc_textOrderNrField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textOrderNrField.insets = new Insets(0, 0, 5, 5);
		gbc_textOrderNrField.gridx = 1;
		gbc_textOrderNrField.gridy = 0;
		NorthPane.add(textOrderNrField, gbc_textOrderNrField);
		
		btnSearchOrder = new JButton("Søg ordre nr");
		btnSearchOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSearchOrder();
			}
		});
		gbc_btnSearchOrder = new GridBagConstraints();
		gbc_btnSearchOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSearchOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearchOrder.anchor = GridBagConstraints.NORTH;
		gbc_btnSearchOrder.gridx = 2;
		gbc_btnSearchOrder.gridy = 0;
		NorthPane.add(btnSearchOrder, gbc_btnSearchOrder);
		
		btnOdreNrButton = new JButton("Tilføj ordre nr");
		btnOdreNrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddOrderNr();
			}
		});
		gbc_btnOrderNrButton = new GridBagConstraints();
		gbc_btnOrderNrButton.anchor = GridBagConstraints.NORTH;
		gbc_btnOrderNrButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOrderNrButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnOrderNrButton.gridx = 1;
		gbc_btnOrderNrButton.gridy = 1;
		NorthPane.add(btnOdreNrButton, gbc_btnOrderNrButton);
		
		lblBlank = new JLabel(" ");
		gbc_lblBlank = new GridBagConstraints();
		gbc_lblBlank.insets = new Insets(0, 0, 0, 5);
		gbc_lblBlank.gridx = 0;
		gbc_lblBlank.gridy = 3;
		NorthPane.add(lblBlank, gbc_lblBlank);
		
		lblCurrentStatus = new JLabel("Status:");
		gbc_lblCurrentStatus = new GridBagConstraints();
		gbc_lblCurrentStatus.insets = new Insets(0, 0, 0, 5);
		gbc_lblCurrentStatus.gridx = 1;
		gbc_lblCurrentStatus.gridy = 3;
		NorthPane.add(lblCurrentStatus, gbc_lblCurrentStatus);
		lblCurrentStatus.setVisible(false);
		
		lblChangeStatus = new JLabel("Ændre status");
		gbc_lblChangeStatus = new GridBagConstraints();
		gbc_lblChangeStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblChangeStatus.gridx = 0;
		gbc_lblChangeStatus.gridy = 2;
		NorthPane.add(lblChangeStatus, gbc_lblChangeStatus);
		
		choice = new Choice();
		gbc_choice = new GridBagConstraints();
		gbc_choice.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice.insets = new Insets(0, 0, 5, 5);
		gbc_choice.gridx = 1;
		gbc_choice.gridy = 2;
		NorthPane.add(choice, gbc_choice);
		choice.add("OnHold");
		choice.add("Accepted");
		choice.add("Paid");
		choice.add("Overdue");
		choice.add("Cancelled");
		
		choice.addItemListener(new ItemListener(){
			
			
			public void itemStateChanged(ItemEvent e) {
				dropDownChoice = handleSave(e);
		        
			}
		});
		
		
		
		SouthPane = new JPanel();
		contentPane.add(SouthPane, BorderLayout.SOUTH);
		SouthPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnSendInvoice = new JButton("Send faktura");
		btnSendInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSendFak();
			}
		});
		SouthPane.add(btnSendInvoice);
		btnSendInvoice.setEnabled(false);
		
		btnSave = new JButton("Gem");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				handleBtnSave(dropDownChoice);
			}
		});
		SouthPane.add(btnSave);
		
		btnBack = new JButton("Tilbage");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleTilbageButton();
			}
		});
		SouthPane.add(btnBack);
		
		CenterPane = new JPanel();
		contentPane.add(CenterPane, BorderLayout.CENTER);
		CenterPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		CenterPane.add(scrollPane);
		
		table = new JTable();
		
		orderLineTableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Produkt", "Antal", "Pris"
				}
				
				);
		
		table.setModel(orderLineTableModel);
		
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		CenterPane.add(panel, BorderLayout.SOUTH);
		gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{282, 163, 0};
		gbl_panel.rowHeights = new int[]{13, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblDiscount = new JLabel("Rabat:");
		gbc_lblDiscount = new GridBagConstraints();
		gbc_lblDiscount.fill = GridBagConstraints.BOTH;
		gbc_lblDiscount.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiscount.gridx = 0;
		gbc_lblDiscount.gridy = 0;
		panel.add(lblDiscount, gbc_lblDiscount);
		
		lblPrice = new JLabel("Total pris:");
		gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.fill = GridBagConstraints.BOTH;
		gbc_lblPrice.gridx = 1;
		gbc_lblPrice.gridy = 0;
		panel.add(lblPrice, gbc_lblPrice);
	}

	private String handleSave(ItemEvent e) {
		Choice source = (Choice)e.getSource();
        String selectedChoice = source.getSelectedItem();
        return selectedChoice;
        //osc.changeOrderStatus(selectedChoice);
		
		//JOptionPane.showMessageDialog(this, osc.getOrder().getOrderStatus());
	}
	
	private void handleBtnSave(String dropDownChoice) {
		
        osc.changeOrderStatus(dropDownChoice);
        lblCurrentStatus.setText("Status: " + foundOrder.getOrderStatus());
        btnSendInvoice.setEnabled(true);
	    
        // Uncomment to show the change in a popup
		//JOptionPane.showMessageDialog(this, osc.getOrder().getOrderStatus());     
	}
	

	private void handleSendFak() {
		JOptionPane.showMessageDialog(this, "Ordren er sendt til " + foundOrder.getCustomer().getName() + "\n" 
				+ "På email: " + foundOrder.getCustomer().getEmail()	
				);
		
		this.setVisible(false);
        this.dispose();	
	}
	
	private Object[] orderLineToObjectArray(OrderLine ol) {
		String productName = ol.getProduct().getName();
		int quantity = ol.getQuantity();
		double price = ol.getProduct().getPrice().getSalesPrice()*quantity;
		
		return new Object[] {productName,quantity,price};
	}
	
	private void handleAddOrderNr() {
		foundOrder = osc.findOrderByNr(textOrderNrField.getText());
		
		for(OrderLine currentOrderLine:foundOrder.getOrderLines()) {
			orderLineTableModel.addRow(orderLineToObjectArray(currentOrderLine));
		}
		lblDiscount.setText("Rabat: " + returnDiscount() + "%");
		lblPrice.setText("Total pris: " + returnPrice() + " DKK");
		
		lblCurrentStatus.setText("Status: " + foundOrder.getOrderStatus());
		lblCurrentStatus.setVisible(true);	
	}
	
	private void handleSearchOrder() {
		// TODO Auto-generated method stub
		
	}
	
	private double returnDiscount() {	
		return foundOrder.getCustomer().getCustomerCategory().calculateDiscountPercent();
	}
	
	private double returnPrice() {
		return foundOrder.calculateTotalPrice();
	}

	private void handleTilbageButton() {
		this.setVisible(false);
		this.dispose();	
	}
}
