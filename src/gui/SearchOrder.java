package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Customer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SearchOrder extends JDialog {

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
	private JLabel lblCustomerID;
	private JTextField textCustomerIDField_1;

	public SearchOrder() {
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
			gbl_northPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_northPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_northPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			northPanel.setLayout(gbl_northPanel);
			{
				lblCustomerID = new JLabel("Kunde ID:");
				GridBagConstraints gbc_lblCustomerID = new GridBagConstraints();
				gbc_lblCustomerID.insets = new Insets(0, 0, 5, 5);
				gbc_lblCustomerID.gridx = 0;
				gbc_lblCustomerID.gridy = 0;
				northPanel.add(lblCustomerID, gbc_lblCustomerID);
			}
			{
				textCustomerIDField_1 = new JTextField();
				textCustomerIDField_1.setColumns(10);
				GridBagConstraints gbc_textCustomerIDField_1 = new GridBagConstraints();
				gbc_textCustomerIDField_1.insets = new Insets(0, 0, 5, 0);
				gbc_textCustomerIDField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textCustomerIDField_1.gridx = 1;
				gbc_textCustomerIDField_1.gridy = 0;
				northPanel.add(textCustomerIDField_1, gbc_textCustomerIDField_1);
			}
			{
				lblPCustomerName = new JLabel("Kunde navn:");
				lblPCustomerName.setHorizontalTextPosition(SwingConstants.LEFT);
				lblPCustomerName.setHorizontalAlignment(SwingConstants.LEFT);
				gbc_lblPCustomerName = new GridBagConstraints();
				gbc_lblPCustomerName.insets = new Insets(0, 0, 5, 5);
				gbc_lblPCustomerName.gridx = 0;
				gbc_lblPCustomerName.gridy = 1;
				northPanel.add(lblPCustomerName, gbc_lblPCustomerName);
			}
			{
				textFieldCustomerName = new JTextField();
				gbc_textFieldCustomerName = new GridBagConstraints();
				gbc_textFieldCustomerName.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldCustomerName.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldCustomerName.gridx = 1;
				gbc_textFieldCustomerName.gridy = 1;
				northPanel.add(textFieldCustomerName, gbc_textFieldCustomerName);
				textFieldCustomerName.setColumns(10);
			}
			{
				lblEmail = new JLabel("Kunde e-mail:");
				lblEmail.setHorizontalTextPosition(SwingConstants.LEFT);
				lblEmail.setBackground(new Color(240, 240, 240));
				lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
				gbc_lblEmail = new GridBagConstraints();
				gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
				gbc_lblEmail.gridx = 0;
				gbc_lblEmail.gridy = 2;
				northPanel.add(lblEmail, gbc_lblEmail);
			}
			{
				textFieldCustomerEmail = new JTextField();
				gbc_textFieldCustomerEmail = new GridBagConstraints();
				gbc_textFieldCustomerEmail.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldCustomerEmail.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldCustomerEmail.gridx = 1;
				gbc_textFieldCustomerEmail.gridy = 2;
				northPanel.add(textFieldCustomerEmail, gbc_textFieldCustomerEmail);
				textFieldCustomerEmail.setColumns(10);
			}
			{
				lblCustomerPhoneNr = new JLabel("Kunde tlf. nr:");
				lblCustomerPhoneNr.setHorizontalTextPosition(SwingConstants.LEFT);
				lblCustomerPhoneNr.setHorizontalAlignment(SwingConstants.LEFT);
				gbc_lblCustomerPhoneNr = new GridBagConstraints();
				gbc_lblCustomerPhoneNr.insets = new Insets(0, 0, 5, 5);
				gbc_lblCustomerPhoneNr.gridx = 0;
				gbc_lblCustomerPhoneNr.gridy = 3;
				northPanel.add(lblCustomerPhoneNr, gbc_lblCustomerPhoneNr);
			}
			{
				textFieldCustomerPhoneNr = new JTextField();
				gbc_textFieldCustomerPhoneNr = new GridBagConstraints();
				gbc_textFieldCustomerPhoneNr.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldCustomerPhoneNr.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldCustomerPhoneNr.gridx = 1;
				gbc_textFieldCustomerPhoneNr.gridy = 3;
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
				gbc_btnSearch.gridy = 4;
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
						handleOKButton();
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
						handleBackButton();
					}
				});
				
				cancelButton.setActionCommand("Tilbage");
				buttonPane.add(cancelButton);
			}
		}
		displayCustomers = new ArrayList<>();
		searchCustomerTableModel.initCustomerList();
	}

	private void handleBackButton() {
		// TODO Auto-generated method stub
		
	}

	private void handleOKButton() {
		// TODO Auto-generated method stub
		
	}

	private void handleSearchButton() {
		// TODO Auto-generated method stub
		
	}
}
