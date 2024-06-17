package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.CustomerController;
import model.Customer;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class SearchCustomer extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable customerTable;
	private SearchCustomerTableModel searchCustomerTableModel;
	private JTextField textFieldCustomerName;
	private JTextField textFieldCustomerEmail;
	private JTextField textFieldCustomerPhoneNr;
	private JPanel northPanel;
	private JLabel lblPCustomerName;
	private JLabel lblEmail;
	private JLabel lblCustomerPhoneNr;
	private JButton btnSearch;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JScrollPane scrollPane;
	private GridBagLayout gbl_northPanel;
	private GridBagConstraints gbc_lblPCustomerName;
	private GridBagConstraints gbc_textFieldCustomerName;
	private GridBagConstraints gbc_lblEmail;
	private GridBagConstraints gbc_textFieldCustomerEmail;
	private GridBagConstraints gbc_lblCustomerPhoneNr;
	private GridBagConstraints gbc_textFieldCustomerPhoneNr;
	private GridBagConstraints gbc_btnSearch;
	private ArrayList<Customer> displayCustomers;
	private JTextField textCustomerIDField;
	private SearchCustomerTableModel newSearchCustomerTableModel;
	private boolean searchPress;

	public SearchCustomer(JTextField textCustomerIDField) {
		this.textCustomerIDField = textCustomerIDField;
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
			customerTable = new JTable();	
			searchCustomerTableModel= new SearchCustomerTableModel();
			customerTable.setModel(searchCustomerTableModel);
			scrollPane.setViewportView(customerTable);
		}	
		{
			northPanel = new JPanel();
			contentPanel.add(northPanel, BorderLayout.NORTH);
			gbl_northPanel = new GridBagLayout();
			gbl_northPanel.columnWidths = new int[]{83, 253, 0};
			gbl_northPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_northPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_northPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			northPanel.setLayout(gbl_northPanel);
			{
				lblPCustomerName = new JLabel("Kunde navn:");
				lblPCustomerName.setHorizontalTextPosition(SwingConstants.LEFT);
				lblPCustomerName.setHorizontalAlignment(SwingConstants.LEFT);
				gbc_lblPCustomerName = new GridBagConstraints();
				gbc_lblPCustomerName.insets = new Insets(0, 0, 5, 5);
				gbc_lblPCustomerName.anchor = GridBagConstraints.EAST;
				gbc_lblPCustomerName.gridx = 0;
				gbc_lblPCustomerName.gridy = 0;
				northPanel.add(lblPCustomerName, gbc_lblPCustomerName);
			}
			{
				textFieldCustomerName = new JTextField();
				gbc_textFieldCustomerName = new GridBagConstraints();
				gbc_textFieldCustomerName.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldCustomerName.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldCustomerName.gridx = 1;
				gbc_textFieldCustomerName.gridy = 0;
				northPanel.add(textFieldCustomerName, gbc_textFieldCustomerName);
				textFieldCustomerName.setColumns(10);
			}
			{
				lblEmail = new JLabel("Kunde e-mail:");
				lblEmail.setHorizontalTextPosition(SwingConstants.LEFT);
				lblEmail.setBackground(new Color(240, 240, 240));
				lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
				gbc_lblEmail = new GridBagConstraints();
				gbc_lblEmail.anchor = GridBagConstraints.EAST;
				gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
				gbc_lblEmail.gridx = 0;
				gbc_lblEmail.gridy = 1;
				northPanel.add(lblEmail, gbc_lblEmail);
			}
			{
				textFieldCustomerEmail = new JTextField();
				gbc_textFieldCustomerEmail = new GridBagConstraints();
				gbc_textFieldCustomerEmail.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldCustomerEmail.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldCustomerEmail.gridx = 1;
				gbc_textFieldCustomerEmail.gridy = 1;
				northPanel.add(textFieldCustomerEmail, gbc_textFieldCustomerEmail);
				textFieldCustomerEmail.setColumns(10);
			}
			{
				lblCustomerPhoneNr = new JLabel("Kunde tlf. nr:");
				lblCustomerPhoneNr.setHorizontalTextPosition(SwingConstants.LEFT);
				lblCustomerPhoneNr.setHorizontalAlignment(SwingConstants.LEFT);
				gbc_lblCustomerPhoneNr = new GridBagConstraints();
				gbc_lblCustomerPhoneNr.anchor = GridBagConstraints.EAST;
				gbc_lblCustomerPhoneNr.insets = new Insets(0, 0, 5, 5);
				gbc_lblCustomerPhoneNr.gridx = 0;
				gbc_lblCustomerPhoneNr.gridy = 2;
				northPanel.add(lblCustomerPhoneNr, gbc_lblCustomerPhoneNr);
			}
			{
				textFieldCustomerPhoneNr = new JTextField();
				gbc_textFieldCustomerPhoneNr = new GridBagConstraints();
				gbc_textFieldCustomerPhoneNr.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldCustomerPhoneNr.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldCustomerPhoneNr.gridx = 1;
				gbc_textFieldCustomerPhoneNr.gridy = 2;
				northPanel.add(textFieldCustomerPhoneNr, gbc_textFieldCustomerPhoneNr);
				textFieldCustomerPhoneNr.setColumns(10);
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
				cancelButton = new JButton("Tilbage");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleCancelButton();
					}
				});
				cancelButton.setActionCommand("Tilbage");
				buttonPane.add(cancelButton);
			}
		}
		displayCustomers = new ArrayList<>();
		searchCustomerTableModel.initCustomerList();
	}

	private void handleCancelButton() {
		this.setVisible(false);
		this.dispose();
	}

	private void handleOkButton() {
		int selectedRow = customerTable.getSelectedRow();
		Customer selectedCustomer;
		
		if (selectedRow != -1) {
			if (searchPress) {
				selectedCustomer = newSearchCustomerTableModel.getSelectedCustomer(selectedRow);
			} else {
				selectedCustomer = searchCustomerTableModel.getSelectedCustomer(selectedRow);
			}
			String customerID = selectedCustomer.getCustomerID();
			textCustomerIDField.setText(customerID);
	        this.setVisible(false);
	        this.dispose();
			} else {
        JOptionPane.showMessageDialog(this, "Vælg venligst en kunde");
    	}
	}
	
	private void handleSearchButton() {
		CustomerController cc = new CustomerController();
		searchPress = false;
		
		String searchString;
		if(!textFieldCustomerName.getText().equals("")) {
			searchString = textFieldCustomerName.getText();
			displayCustomers = cc.getCustomersByName(searchString);
			searchPress = true;
		} else if(!textFieldCustomerEmail.getText().equals("")) {
			searchString = textFieldCustomerEmail.getText();
			displayCustomers = cc.getCustomerByEmail(searchString);
			searchPress = true;
		} else if(!textFieldCustomerPhoneNr.getText().equals("")) {
			searchString = textFieldCustomerPhoneNr.getText();
			displayCustomers = cc.getCustomerByPhoneNr(searchString);
			searchPress = true;
		} else {
			JOptionPane.showMessageDialog(this,"Udfyld venligst mindst et af felterne.");
			displayCustomers = searchCustomerTableModel.getCustomers();
		}
		
		newSearchCustomerTableModel = new SearchCustomerTableModel();
		newSearchCustomerTableModel.setCustomers(displayCustomers);
        customerTable.setModel(newSearchCustomerTableModel);
	}

}
