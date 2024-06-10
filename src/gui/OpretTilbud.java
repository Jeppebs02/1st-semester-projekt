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

public class OpretTilbud extends JDialog {

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
	private JPanel northPanel;
	private JLabel lblStregkodeLabel;
	private JLabel lblAntalLabel;
	private JLabel lblKundeIDLabel;
	private JTextField textCustomerIDField;
	private JTextField textBarcodeField;
	private JButton btnSøgProduktButton;
	private JTextField textQuantityField;
	private JButton btnSøgKundeIDButton;
	private JButton btnTilføjProduktButton;
	private JButton btnSgKunde;
	private JPanel pricePanel;
	private JLabel lblTotalPrisLabel;
	private JLabel lblRabat;
	private JLabel lblNewLabel;
	
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
		
		lblOrdreLabel = new JLabel("Ordre");
		contentPanel.add(lblOrdreLabel, BorderLayout.NORTH);
		
		pricePanel = new JPanel();
		contentPanel.add(pricePanel, BorderLayout.SOUTH);
		GridBagLayout gbl_pricePanel = new GridBagLayout();
		gbl_pricePanel.columnWidths = new int[]{185, 0, 0, 47, 30, 0};
		gbl_pricePanel.rowHeights = new int[]{13, 0};
		gbl_pricePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pricePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pricePanel.setLayout(gbl_pricePanel);
		
		lblRabat = new JLabel("Rabat:");
		GridBagConstraints gbc_lblRabat = new GridBagConstraints();
		gbc_lblRabat.insets = new Insets(0, 0, 0, 5);
		gbc_lblRabat.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRabat.gridx = 0;
		gbc_lblRabat.gridy = 0;
		pricePanel.add(lblRabat, gbc_lblRabat);
		
		lblTotalPrisLabel = new JLabel("Total pris:");
		GridBagConstraints gbc_lblTotalPrisLabel = new GridBagConstraints();
		gbc_lblTotalPrisLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTotalPrisLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalPrisLabel.gridx = 1;
		gbc_lblTotalPrisLabel.gridy = 0;
		pricePanel.add(lblTotalPrisLabel, gbc_lblTotalPrisLabel);
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
		
		northPanel = new JPanel();
		getContentPane().add(northPanel, BorderLayout.NORTH);
		GridBagLayout gbl_northPanel = new GridBagLayout();
		gbl_northPanel.columnWidths = new int[]{0, 0};
		gbl_northPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_northPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_northPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		northPanel.setLayout(gbl_northPanel);
		
		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		northPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		lblStregkodeLabel = new JLabel("Stregkode");
		GridBagConstraints gbc_lblStregkodeLabel = new GridBagConstraints();
		gbc_lblStregkodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblStregkodeLabel.gridx = 0;
		gbc_lblStregkodeLabel.gridy = 3;
		northPanel.add(lblStregkodeLabel, gbc_lblStregkodeLabel);
		
		lblAntalLabel = new JLabel("Antal");
		GridBagConstraints gbc_lblAntalLabel = new GridBagConstraints();
		gbc_lblAntalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntalLabel.gridx = 0;
		gbc_lblAntalLabel.gridy = 4;
		northPanel.add(lblAntalLabel, gbc_lblAntalLabel);
		
		lblKundeIDLabel = new JLabel("Kunde ID");
		GridBagConstraints gbc_lblKundeIDLabel = new GridBagConstraints();
		gbc_lblKundeIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundeIDLabel.gridx = 0;
		gbc_lblKundeIDLabel.gridy = 1;
		northPanel.add(lblKundeIDLabel, gbc_lblKundeIDLabel);
		
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
		
		btnSøgProduktButton = new JButton("Søg produkt");
		GridBagConstraints gbc_btnSøgProduktButton = new GridBagConstraints();
		gbc_btnSøgProduktButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSøgProduktButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnSøgProduktButton.gridx = 2;
		gbc_btnSøgProduktButton.gridy = 3;
		northPanel.add(btnSøgProduktButton, gbc_btnSøgProduktButton);
		
		textQuantityField = new JTextField();
		textQuantityField.setColumns(10);
		GridBagConstraints gbc_textQuantityField = new GridBagConstraints();
		gbc_textQuantityField.insets = new Insets(0, 0, 5, 5);
		gbc_textQuantityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textQuantityField.gridx = 1;
		gbc_textQuantityField.gridy = 4;
		northPanel.add(textQuantityField, gbc_textQuantityField);
		
		btnSøgKundeIDButton = new JButton("Tilføj Kunde");
		btnSøgKundeIDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddCustomer();
			}
		});
		GridBagConstraints gbc_btnSøgKundeIDButton = new GridBagConstraints();
		gbc_btnSøgKundeIDButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSøgKundeIDButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnSøgKundeIDButton.gridx = 1;
		gbc_btnSøgKundeIDButton.gridy = 2;
		northPanel.add(btnSøgKundeIDButton, gbc_btnSøgKundeIDButton);
		
		btnTilføjProduktButton = new JButton("Tilføj produkt");
		btnTilføjProduktButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddProduct();
			}
		});
		GridBagConstraints gbc_btnTilføjProduktButton = new GridBagConstraints();
		gbc_btnTilføjProduktButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTilføjProduktButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnTilføjProduktButton.gridx = 1;
		gbc_btnTilføjProduktButton.gridy = 5;
		northPanel.add(btnTilføjProduktButton, gbc_btnTilføjProduktButton);
		
		btnSgKunde = new JButton("Søg kunde");
		btnSgKunde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnSgKunde = new GridBagConstraints();
		gbc_btnSgKunde.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSgKunde.insets = new Insets(0, 0, 5, 0);
		gbc_btnSgKunde.gridx = 2;
		gbc_btnSgKunde.gridy = 1;
		northPanel.add(btnSgKunde, gbc_btnSgKunde);
		
		oc = new OrderController();
		oc.createOffer();
	}
	
	protected void handleAddCustomer() {
		//TODO Add text label with customers name based on the ID
		if(oc.inputCustomerID(textCustomerIDField.getText())==null) {
			JOptionPane.showMessageDialog(this, "Kunden eksisterer ikke");
			textCustomerIDField.setText("");
		} else {
			textCustomerIDField.setEditable(false);
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
		oc.saveOffer();
		this.setVisible(false);
		this.dispose();
		
	}

	private void handleCancelButton() {
		this.setVisible(false);
		this.dispose();
		
	}
	
	private void handleAddProduct() {
        // TODO Auto-generated method stub
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
        }
        

        //TODO add error when quantity not available + check
        orderLineTableModel.addRow(orderLineToObjectArray(oc.getOrderLines().get(oc.getOrderLines().size()-1)));

        textBarcodeField.setText("");
        textQuantityField.setText("");


    }
	
	
}
