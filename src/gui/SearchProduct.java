package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.CustomerController;
import control.ProductController;
import model.Customer;
import model.Product;

public class SearchProduct extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable productTable;
	private SearchProductTableModel searchProductTableModel;
	private JPanel northPanel;
	private GridBagLayout gbl_northPanel;
	private JLabel lblPProductName;
	private GridBagConstraints gbc_lblPProductName;
	private JTextField textFieldProductName;
	private GridBagConstraints gbc_textFieldProductName;
	private JLabel lblDescription;
	private GridBagConstraints gbc_lblDescription;
	private JTextField textFieldPDescription;
	private GridBagConstraints gbc_textFieldPDescription;
	private JLabel lblCategory;
	private GridBagConstraints gbc_lblCategory;
	private JTextField textFieldCategory;
	private GridBagConstraints gbc_textFieldCategory;
	private JButton btnSearch;
	private GridBagConstraints gbc_btnSearch;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchProduct dialog = new SearchProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchProduct() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
		}
		{
			productTable = new JTable();
			contentPanel.add(productTable, BorderLayout.SOUTH);
			searchProductTableModel= new SearchProductTableModel();
			productTable.setModel(searchProductTableModel);
			scrollPane.setViewportView(productTable);
		}
		{
			northPanel = new JPanel();
			contentPanel.add(northPanel, BorderLayout.NORTH);
			gbl_northPanel = new GridBagLayout();
			gbl_northPanel.columnWidths = new int[]{107, 253, 0};
			gbl_northPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_northPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_northPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			northPanel.setLayout(gbl_northPanel);
			{
				lblPProductName = new JLabel("Produkt navn:");
				gbc_lblPProductName = new GridBagConstraints();
				gbc_lblPProductName.insets = new Insets(0, 0, 5, 5);
				gbc_lblPProductName.anchor = GridBagConstraints.EAST;
				gbc_lblPProductName.gridx = 0;
				gbc_lblPProductName.gridy = 0;
				northPanel.add(lblPProductName, gbc_lblPProductName);
			}
			{
				textFieldProductName = new JTextField();
				gbc_textFieldProductName = new GridBagConstraints();
				gbc_textFieldProductName.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldProductName.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldProductName.gridx = 1;
				gbc_textFieldProductName.gridy = 0;
				northPanel.add(textFieldProductName, gbc_textFieldProductName);
				textFieldProductName.setColumns(10);
			}
			{
				lblDescription = new JLabel("Produkt beskrivelse:");
				gbc_lblDescription = new GridBagConstraints();
				gbc_lblDescription.anchor = GridBagConstraints.EAST;
				gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
				gbc_lblDescription.gridx = 0;
				gbc_lblDescription.gridy = 1;
				northPanel.add(lblDescription, gbc_lblDescription);
			}
			{
				textFieldPDescription = new JTextField();
				gbc_textFieldPDescription = new GridBagConstraints();
				gbc_textFieldPDescription.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldPDescription.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldPDescription.gridx = 1;
				gbc_textFieldPDescription.gridy = 1;
				northPanel.add(textFieldPDescription, gbc_textFieldPDescription);
				textFieldPDescription.setColumns(10);
			}
			{
				lblCategory = new JLabel("Produkt kategori:");
				gbc_lblCategory = new GridBagConstraints();
				gbc_lblCategory.anchor = GridBagConstraints.EAST;
				gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
				gbc_lblCategory.gridx = 0;
				gbc_lblCategory.gridy = 2;
				northPanel.add(lblCategory, gbc_lblCategory);
			}
			{
				textFieldCategory = new JTextField();
				gbc_textFieldCategory = new GridBagConstraints();
				gbc_textFieldCategory.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldCategory.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldCategory.gridx = 1;
				gbc_textFieldCategory.gridy = 2;
				northPanel.add(textFieldCategory, gbc_textFieldCategory);
				textFieldCategory.setColumns(10);
			}
			{
				btnSearch = new JButton("Søg");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleSearchButton();
					}
				});
				gbc_btnSearch = new GridBagConstraints();
				gbc_btnSearch.gridx = 1;
				gbc_btnSearch.gridy = 3;
				northPanel.add(btnSearch, gbc_btnSearch);
			}
		}
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
		searchProductTableModel.initProductTable();
	}

	private void handleSearchButton() {
		ProductController pc = new ProductController();
		
		String searchString;
		ArrayList<Product> displayProducts = new ArrayList<>();
		if(!textFieldProductName.getText().equals("")) {
			searchString = textFieldProductName.getText();
			displayProducts = pc.getProductsByName(searchString);
		} else if(!textFieldPDescription.getText().equals("")) {
			searchString = textFieldPDescription.getText();
			displayProducts = pc.getProductsByDescription(searchString);
		} else if(!textFieldCategory.getText().equals("")) {
			searchString = textFieldCategory.getText();
			displayProducts = pc.getProductsByCategory(searchString);
		} else {
			JOptionPane.showMessageDialog(this,"Udfyld venligst mindst et af felterne.");
		}
		
		SearchProductTableModel newSearchProductTableModel = new SearchProductTableModel();
		newSearchProductTableModel.setProducts(displayProducts);
        productTable.setModel(newSearchProductTableModel);
	}

	private void handleOkButton() {
		// TODO Auto-generated method stub
		
	}

	private void handleCancelButton() {
		this.setVisible(false);
		this.dispose();	
	}
}
