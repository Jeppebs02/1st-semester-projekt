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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CreateOffer extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable orderLineTable;
	private JScrollPane scrollPane;
	private JLabel lblOrdreLabel;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private OrderController oc;
	private DefaultTableModel orderLineTableModel;
	//private OrderTableModel orderLineTableModel;
	private JPanel northPanel;
	private JLabel lblBarcode;
	private JLabel lblQuantity;
	private JLabel lblCustomerID;
	private JTextField textCustomerIDField;
	private JTextField textBarcodeField;
	private JButton btnSearchProduct;
	private JTextField textQuantityField;
	private JButton btnAddCustomer;
	private JButton btnAddProduct;
	private JButton btnSearchCustomer;
	private JPanel pricePanel;
	private JLabel lblTotalPrice;
	private JLabel lblDiscount;
	private JLabel lblBlank;
	private String orderNr;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TryMe.addData();
			CreateOffer dialog = new CreateOffer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateOffer() {
		oc = new OrderController();
		oc.createOffer();
		setModal(true);
		setBounds(100, 100, 373, 516);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
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
		
		orderNr = oc.generateOrderNr();
		lblOrdreLabel = new JLabel("Ordre nr: " + orderNr);
		contentPanel.add(lblOrdreLabel, BorderLayout.NORTH);
		
		pricePanel = new JPanel();
		contentPanel.add(pricePanel, BorderLayout.SOUTH);
		GridBagLayout gbl_pricePanel = new GridBagLayout();
		gbl_pricePanel.columnWidths = new int[]{297, 159, 0};
		gbl_pricePanel.rowHeights = new int[]{13, 0};
		gbl_pricePanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pricePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pricePanel.setLayout(gbl_pricePanel);
		
		lblDiscount = new JLabel("Rabat:");
		GridBagConstraints gbc_lblRabat = new GridBagConstraints();
		gbc_lblRabat.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRabat.insets = new Insets(0, 0, 0, 5);
		gbc_lblRabat.anchor = GridBagConstraints.NORTH;
		gbc_lblRabat.gridx = 0;
		gbc_lblRabat.gridy = 0;
		pricePanel.add(lblDiscount, gbc_lblRabat);
		
		lblTotalPrice = new JLabel("Total pris:");
		GridBagConstraints gbc_lblTotalPrisLabel = new GridBagConstraints();
		gbc_lblTotalPrisLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTotalPrisLabel.gridx = 1;
		gbc_lblTotalPrisLabel.gridy = 0;
		pricePanel.add(lblTotalPrice, gbc_lblTotalPrisLabel);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Send tilbud");
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
				cancelButton = new JButton("Tilbage");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleCancelButton();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
			}
		}
		
		northPanel = new JPanel();
		getContentPane().add(northPanel, BorderLayout.NORTH);
		GridBagLayout gbl_northPanel = new GridBagLayout();
		gbl_northPanel.columnWidths = new int[]{0, 0};
		gbl_northPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_northPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_northPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		northPanel.setLayout(gbl_northPanel);
		
		lblBlank = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		northPanel.add(lblBlank, gbc_lblNewLabel);
		
		lblBarcode = new JLabel("Stregkode");
		GridBagConstraints gbc_lblStregkodeLabel = new GridBagConstraints();
		gbc_lblStregkodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblStregkodeLabel.gridx = 0;
		gbc_lblStregkodeLabel.gridy = 3;
		northPanel.add(lblBarcode, gbc_lblStregkodeLabel);
		
		lblQuantity = new JLabel("Antal");
		GridBagConstraints gbc_lblAntalLabel = new GridBagConstraints();
		gbc_lblAntalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntalLabel.gridx = 0;
		gbc_lblAntalLabel.gridy = 4;
		northPanel.add(lblQuantity, gbc_lblAntalLabel);
		
		lblCustomerID = new JLabel("Kunde ID");
		GridBagConstraints gbc_lblKundeIDLabel = new GridBagConstraints();
		gbc_lblKundeIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundeIDLabel.gridx = 0;
		gbc_lblKundeIDLabel.gridy = 1;
		northPanel.add(lblCustomerID, gbc_lblKundeIDLabel);
		
		textCustomerIDField = new JTextField();
		textCustomerIDField.setColumns(10);
		GridBagConstraints gbc_textCustomerIDField = new GridBagConstraints();
		gbc_textCustomerIDField.insets = new Insets(0, 0, 5, 5);
		gbc_textCustomerIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCustomerIDField.gridx = 1;
		gbc_textCustomerIDField.gridy = 1;
		gbc_textCustomerIDField.weightx = 1.0;
		northPanel.add(textCustomerIDField, gbc_textCustomerIDField);
		
		textBarcodeField = new JTextField();
		textBarcodeField.setColumns(10);
		GridBagConstraints gbc_textBarcodeField = new GridBagConstraints();
		gbc_textBarcodeField.insets = new Insets(0, 0, 5, 5);
		gbc_textBarcodeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBarcodeField.gridx = 1;
		gbc_textBarcodeField.gridy = 3;
		northPanel.add(textBarcodeField, gbc_textBarcodeField);
		
		btnSearchProduct = new JButton("Søg produkt");
		GridBagConstraints gbc_btnSøgProduktButton = new GridBagConstraints();
		gbc_btnSøgProduktButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSøgProduktButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnSøgProduktButton.gridx = 2;
		gbc_btnSøgProduktButton.gridy = 3;
		northPanel.add(btnSearchProduct, gbc_btnSøgProduktButton);
		
		textQuantityField = new JTextField();
		textQuantityField.setColumns(10);
		GridBagConstraints gbc_textQuantityField = new GridBagConstraints();
		gbc_textQuantityField.insets = new Insets(0, 0, 5, 5);
		gbc_textQuantityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textQuantityField.gridx = 1;
		gbc_textQuantityField.gridy = 4;
		northPanel.add(textQuantityField, gbc_textQuantityField);
		
		btnAddCustomer = new JButton("Tilføj Kunde");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddCustomer();
			}
		});
		GridBagConstraints gbc_btnSøgKundeIDButton = new GridBagConstraints();
		gbc_btnSøgKundeIDButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSøgKundeIDButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnSøgKundeIDButton.gridx = 1;
		gbc_btnSøgKundeIDButton.gridy = 2;
		northPanel.add(btnAddCustomer, gbc_btnSøgKundeIDButton);
		
		btnAddProduct = new JButton("Tilføj produkt");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddProduct();
			}
		});
		GridBagConstraints gbc_btnTilføjProduktButton = new GridBagConstraints();
		gbc_btnTilføjProduktButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTilføjProduktButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnTilføjProduktButton.gridx = 1;
		gbc_btnTilføjProduktButton.gridy = 5;
		northPanel.add(btnAddProduct, gbc_btnTilføjProduktButton);
		
		btnSearchCustomer = new JButton("Søg kunde");
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnSgKunde = new GridBagConstraints();
		gbc_btnSgKunde.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSgKunde.insets = new Insets(0, 0, 5, 0);
		gbc_btnSgKunde.gridx = 2;
		gbc_btnSgKunde.gridy = 1;
		northPanel.add(btnSearchCustomer, gbc_btnSgKunde);
		
		
		
	}
	
	private void handleAddCustomer() {
		//TODO Add text label with customers name based on the ID
		if(oc.inputCustomerID(textCustomerIDField.getText())==null) {
			JOptionPane.showMessageDialog(this, "Kunden eksisterer ikke");
			textCustomerIDField.setText("");
		} else {
			textCustomerIDField.setEditable(false);
			lblDiscount.setText("Rabat: " + returnDiscount() + "%");
		}
		
		
		
	}

	private Object[] orderLineToObjectArray(OrderLine ol) {
		String productName = ol.getProduct().getName();
		int quantity = ol.getQuantity();
		double price = ol.getProduct().getPrice().getSalesPrice()*quantity;
		
		return new Object[] {productName,quantity,price};
	}

	private void handleOkButton() {
		// TODO Add a receipt
		oc.saveOffer(orderNr);
		this.setVisible(false);
		this.dispose();
		
	}

	private void handleCancelButton() {
		this.setVisible(false);
		this.dispose();
		
	}
	
	private double returnDiscount() {
		
		return oc.getCurrentOrder().getCustomer().getCustomerCategory().calculateDiscountPercent();
	}
	
	private double returnPrice() {
		
		return oc.getCurrentOrder().calculateTotalPrice();
	}
	
	private void handleAddProduct() {

        String barcode = textBarcodeField.getText();
        int quantity=0;

        try {
            if (textQuantityField.getText().equals("")) {
                quantity = 1;
            }else {

                quantity = Integer.parseInt(textQuantityField.getText());
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Antal må ikke indeholde bogstaver");
            return;
        }

        //String quantityText = textAntalField.getText();



        Product product = oc.inputProduct(barcode, quantity);

        if (product == null) {
            JOptionPane.showMessageDialog(this, "Produktet eksistere ikke");
            return;
        } else if (quantity<product.getInventory().getStock()) {
        	orderLineTableModel.addRow(orderLineToObjectArray(oc.getOrderLines().get(oc.getOrderLines().size()-1)));
        } else {
        	JOptionPane.showMessageDialog(this, "Der er ikke nok af produktet: " + product.getName()+".\n"+"Der er "+String.valueOf(product.getInventory().getStock())+" tilbage.");
        }
        
       

        //TODO add error when quantity not available + check
       

        textBarcodeField.setText("");
        textQuantityField.setText("");
        
        lblTotalPrice.setText("Total pris: " + returnPrice() + " DKK");
        


    }
	
	
}
