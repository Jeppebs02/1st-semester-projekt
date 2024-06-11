package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.CustomerController;
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
	private CustomerController cc;
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
	private GridBagLayout gbl_pricePanel;
	private GridBagConstraints gbc_lblDiscount;
	private GridBagConstraints gbc_lblTotalPriceLabel;
	private GridBagLayout gbl_northPanel;
	private GridBagConstraints gbc_lblBlank;
	private GridBagConstraints gbc_lblBarcode;
	private GridBagConstraints gbc_lblQuantity;
	private GridBagConstraints gbc_lblCustomerID;
	private GridBagConstraints gbc_textCustomerIDField;
	private GridBagConstraints gbc_textBarcodeField;
	private GridBagConstraints gbc_btnSearchProduct;
	private GridBagConstraints gbc_textQuantityField;
	private GridBagConstraints gbc_btnAddCustomer;
	private GridBagConstraints gbc_btnAddProduct;
	private GridBagConstraints gbc_btnSearchCustomer;
	
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

	public CreateOffer() {
		oc = new OrderController();
		oc.createOffer();
		cc = new CustomerController();
		
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
		gbl_pricePanel = new GridBagLayout();
		gbl_pricePanel.columnWidths = new int[]{297, 159, 0};
		gbl_pricePanel.rowHeights = new int[]{13, 0};
		gbl_pricePanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pricePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pricePanel.setLayout(gbl_pricePanel);
		
		lblDiscount = new JLabel("Rabat:");
		gbc_lblDiscount = new GridBagConstraints();
		gbc_lblDiscount.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDiscount.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiscount.anchor = GridBagConstraints.NORTH;
		gbc_lblDiscount.gridx = 0;
		gbc_lblDiscount.gridy = 0;
		pricePanel.add(lblDiscount, gbc_lblDiscount);
		
		lblTotalPrice = new JLabel("Total pris:");
		gbc_lblTotalPriceLabel = new GridBagConstraints();
		gbc_lblTotalPriceLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTotalPriceLabel.gridx = 1;
		gbc_lblTotalPriceLabel.gridy = 0;
		pricePanel.add(lblTotalPrice, gbc_lblTotalPriceLabel);
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
		gbl_northPanel = new GridBagLayout();
		gbl_northPanel.columnWidths = new int[]{0, 0};
		gbl_northPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_northPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_northPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		northPanel.setLayout(gbl_northPanel);
		
		lblBlank = new JLabel("");
		gbc_lblBlank = new GridBagConstraints();
		gbc_lblBlank.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBlank.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlank.gridx = 0;
		gbc_lblBlank.gridy = 0;
		northPanel.add(lblBlank, gbc_lblBlank);
		
		lblBarcode = new JLabel("Stregkode");
		gbc_lblBarcode = new GridBagConstraints();
		gbc_lblBarcode.insets = new Insets(0, 0, 5, 5);
		gbc_lblBarcode.gridx = 0;
		gbc_lblBarcode.gridy = 3;
		northPanel.add(lblBarcode, gbc_lblBarcode);
		
		lblQuantity = new JLabel("Antal");
		gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity.gridx = 0;
		gbc_lblQuantity.gridy = 4;
		northPanel.add(lblQuantity, gbc_lblQuantity);
		
		lblCustomerID = new JLabel("Kunde ID");
		gbc_lblCustomerID = new GridBagConstraints();
		gbc_lblCustomerID.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerID.gridx = 0;
		gbc_lblCustomerID.gridy = 1;
		northPanel.add(lblCustomerID, gbc_lblCustomerID);
		
		textCustomerIDField = new JTextField();
		textCustomerIDField.setColumns(10);
		gbc_textCustomerIDField = new GridBagConstraints();
		gbc_textCustomerIDField.insets = new Insets(0, 0, 5, 5);
		gbc_textCustomerIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCustomerIDField.gridx = 1;
		gbc_textCustomerIDField.gridy = 1;
		gbc_textCustomerIDField.weightx = 1.0;
		northPanel.add(textCustomerIDField, gbc_textCustomerIDField);
		
		textBarcodeField = new JTextField();
		textBarcodeField.setColumns(10);
		gbc_textBarcodeField = new GridBagConstraints();
		gbc_textBarcodeField.insets = new Insets(0, 0, 5, 5);
		gbc_textBarcodeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBarcodeField.gridx = 1;
		gbc_textBarcodeField.gridy = 3;
		northPanel.add(textBarcodeField, gbc_textBarcodeField);
		
		btnSearchProduct = new JButton("Søg produkt");
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSearchProductButton();
			}
		});
		gbc_btnSearchProduct = new GridBagConstraints();
		gbc_btnSearchProduct.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSearchProduct.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearchProduct.gridx = 2;
		gbc_btnSearchProduct.gridy = 3;
		northPanel.add(btnSearchProduct, gbc_btnSearchProduct);
		
		textQuantityField = new JTextField();
		textQuantityField.setColumns(10);
		gbc_textQuantityField = new GridBagConstraints();
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
		gbc_btnAddCustomer = new GridBagConstraints();
		gbc_btnAddCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddCustomer.gridx = 1;
		gbc_btnAddCustomer.gridy = 2;
		northPanel.add(btnAddCustomer, gbc_btnAddCustomer);
		
		btnAddProduct = new JButton("Tilføj produkt");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddProduct();
			}
		});
		gbc_btnAddProduct = new GridBagConstraints();
		gbc_btnAddProduct.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddProduct.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddProduct.gridx = 1;
		gbc_btnAddProduct.gridy = 5;
		northPanel.add(btnAddProduct, gbc_btnAddProduct);
		
		btnSearchCustomer = new JButton("Søg kunde");
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSeachCustomerButton();
			}
		});
		gbc_btnSearchCustomer = new GridBagConstraints();
		gbc_btnSearchCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSearchCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearchCustomer.gridx = 2;
		gbc_btnSearchCustomer.gridy = 1;
		northPanel.add(btnSearchCustomer, gbc_btnSearchCustomer);	
	}
	
	private void handleSearchProductButton() {
		SearchProduct searchProduct = new SearchProduct();
		searchProduct.setVisible(true);
		
		this.setVisible(false);
	}

	private void handleSeachCustomerButton() {
		SearchCustomer searchCustomer = new SearchCustomer();
		searchCustomer.setVisible(true);
		
		this.setVisible(false);
	}

	private void handleAddCustomer() {
		if(oc.inputCustomerID(textCustomerIDField.getText())==null) {
			JOptionPane.showMessageDialog(this, "Kunden eksisterer ikke");
			textCustomerIDField.setText("");
		} else {
			textCustomerIDField.setEditable(false);
			lblDiscount.setText("Rabat: " + returnDiscount() + "%");
			JOptionPane.showMessageDialog(this, "Kunden: " + cc.getCustomerNameByID(textCustomerIDField.getText())
			+ "\n er tilføjet til ordren");
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
            } else {

                quantity = Integer.parseInt(textQuantityField.getText());
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Antal må ikke indeholde bogstaver");
            return;
        }

        Product product = oc.inputProduct(barcode, quantity);

        if (product == null) {
            JOptionPane.showMessageDialog(this, "Produktet eksistere ikke");
            return;
        } else if (quantity<product.getInventory().getStock()) {
        	orderLineTableModel.addRow(orderLineToObjectArray(oc.getOrderLines().get(oc.getOrderLines().size()-1)));
        } else {
        	JOptionPane.showMessageDialog(this, "Der er ikke nok af produktet: " + product.getName()+".\n"+"Der er "+String.valueOf(product.getInventory().getStock())+" tilbage.");
        }

        textBarcodeField.setText("");
        textQuantityField.setText("");
        
        lblTotalPrice.setText("Total pris: " + returnPrice() + " DKK");
    }
	
	
}
