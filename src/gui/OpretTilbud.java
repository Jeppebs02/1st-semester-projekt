package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.OrderController;
import model.OrderLine;
import model.Product;
import tui.TryMe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpretTilbud extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textAntalField;
	private JTextField textStregkodeField;
	private JTextField textKundeIDField;
	private JTable orderLineTable;
	private JLabel lblStregkodeLabel;
	private JLabel lblAntalLabel;
	private JLabel lblKundeIDLabel;
	private JButton btnSøgProduktButton;
	private JButton btnSøgKundeIDButton;
	private JButton btnTilføjProduktButton;
	private JScrollPane scrollPane;
	private JLabel lblOrdreLabel;
	private JLabel lblTotalPrisLabel;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private OrderController oc;
	private DefaultTableModel orderLineTableModel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TryMe.addData();
			OpretTilbud dialog = new OpretTilbud();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OpretTilbud() {
		setModal(true);
		setBounds(100, 100, 373, 516);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblStregkodeLabel = new JLabel("Stregkode");
			lblStregkodeLabel.setBounds(28, 86, 66, 13);
			contentPanel.add(lblStregkodeLabel);
		}
		
		lblAntalLabel = new JLabel("Antal");
		lblAntalLabel.setBounds(28, 115, 66, 13);
		contentPanel.add(lblAntalLabel);
		
		lblKundeIDLabel = new JLabel("Customer ID");
		lblKundeIDLabel.setBounds(28, 23, 72, 13);
		contentPanel.add(lblKundeIDLabel);
		
		textAntalField = new JTextField();
		textAntalField.setBounds(100, 112, 111, 19);
		contentPanel.add(textAntalField);
		textAntalField.setColumns(10);
		
		textStregkodeField = new JTextField();
		textStregkodeField.setBounds(100, 83, 111, 19);
		contentPanel.add(textStregkodeField);
		textStregkodeField.setColumns(10);
		
		btnSøgProduktButton = new JButton("Søg produkt");
		btnSøgProduktButton.setBounds(240, 82, 92, 21);
		contentPanel.add(btnSøgProduktButton);
		
		textKundeIDField = new JTextField();
		textKundeIDField.setColumns(10);
		textKundeIDField.setBounds(100, 20, 111, 19);
		contentPanel.add(textKundeIDField);
		
		btnSøgKundeIDButton = new JButton("Tilføj Kunde");
		btnSøgKundeIDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddCustomer();
			}
		});
		btnSøgKundeIDButton.setBounds(100, 47, 111, 21);
		contentPanel.add(btnSøgKundeIDButton);
		
		btnTilføjProduktButton = new JButton("Tilføj produkt");
		btnTilføjProduktButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddProduct();
			}
		});
		btnTilføjProduktButton.setBounds(100, 141, 111, 21);
		contentPanel.add(btnTilføjProduktButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 194, 308, 198);
		contentPanel.add(scrollPane);
		
		orderLineTable = new JTable();
		
		//maybe add abstract table model
		orderLineTableModel= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Produkt", "Antal", "Pris"
				}
				
				);
		
		orderLineTable.setModel(orderLineTableModel);
		scrollPane.setViewportView(orderLineTable);
		
		lblOrdreLabel = new JLabel("Ordre");
		lblOrdreLabel.setBounds(24, 171, 66, 13);
		contentPanel.add(lblOrdreLabel);
		
		lblTotalPrisLabel = new JLabel("Total pris:");
		lblTotalPrisLabel.setBounds(28, 425, 66, 13);
		contentPanel.add(lblTotalPrisLabel);
		
		JButton btnSgKunde = new JButton("Søg kunde");
		btnSgKunde.setBounds(240, 19, 92, 21);
		contentPanel.add(btnSgKunde);
		
		JLabel lblRabat = new JLabel("Rabat:");
		lblRabat.setBounds(28, 402, 66, 13);
		contentPanel.add(lblRabat);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleOkButton();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleCancelButton();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
			}
		}
		
		oc = new OrderController();
		oc.createOffer();
	}

	private void handleAddCustomer() {
		
		String CustomerID = textKundeIDField.getText();
		oc.inputCustomerID(CustomerID);
		textKundeIDField.setEditable(false);
		
		
	}

	private void handleAddProduct() {
		// TODO Auto-generated method stub
		String barcode = textStregkodeField.getText();
		int quantity=0;
		
		try {
			if (textAntalField.getText().equals("")) {
			    quantity = 1;
			}else {
				
				quantity = Integer.parseInt(textAntalField.getText());
			}
		
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Antal må ikke indeholde bogstaver");
			return;
		}
		
		//String quantityText = textAntalField.getText();

		
		
		Product product = oc.inputProduct(barcode, quantity);
		
		//TODO add check
		if (product == null) {
			JOptionPane.showMessageDialog(this, "Produktet eksistere ikke");
		}
		
		//TODO add error when quantity not available + check
		orderLineTableModel.addRow(orderLineToObjectArray(oc.getOrderLines().get(oc.getOrderLines().size()-1)));
		
		textStregkodeField.setText("");
		textAntalField.setText("");
		
		
	}
	
	private Object[] orderLineToObjectArray(OrderLine ol) {
		String productName = ol.getProduct().getName();
		int quantity = ol.getQuantity();
		double price = ol.getProduct().getPrice().getSalesPrice()*quantity;
		
		return new Object[] {productName,quantity,price};
	}

	private void handleOkButton() {
		// TODO Add a receipt
		oc.saveOffer();
		this.setVisible(false);
		this.dispose();
		
	}

	private void handleCancelButton() {
		this.setVisible(false);
		this.dispose();
		
	}
}
