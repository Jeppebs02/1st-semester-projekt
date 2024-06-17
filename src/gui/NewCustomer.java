package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Font;

public class NewCustomer extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField Name;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldAdress;

	/**
	 * Create the dialog.
	 */
	public NewCustomer() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{140, 48, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblName = new JLabel("Navn:");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 0;
			gbc_lblName.gridy = 0;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			Name = new JTextField();
			GridBagConstraints gbc_name = new GridBagConstraints();
			gbc_name.insets = new Insets(0, 0, 5, 0);
			gbc_name.fill = GridBagConstraints.HORIZONTAL;
			gbc_name.gridx = 1;
			gbc_name.gridy = 0;
			contentPanel.add(Name, gbc_name);
			Name.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("Email:");
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.anchor = GridBagConstraints.WEST;
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.gridx = 0;
			gbc_lblEmail.gridy = 1;
			contentPanel.add(lblEmail, gbc_lblEmail);
		}
		{
			textFieldEmail = new JTextField();
			textFieldEmail.setColumns(10);
			GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
			gbc_textFieldEmail.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEmail.gridx = 1;
			gbc_textFieldEmail.gridy = 1;
			contentPanel.add(textFieldEmail, gbc_textFieldEmail);
		}
		{
			JLabel lblPhoneNr = new JLabel("Telefon:");
			GridBagConstraints gbc_lblPhoneNr = new GridBagConstraints();
			gbc_lblPhoneNr.anchor = GridBagConstraints.WEST;
			gbc_lblPhoneNr.insets = new Insets(0, 0, 5, 5);
			gbc_lblPhoneNr.gridx = 0;
			gbc_lblPhoneNr.gridy = 2;
			contentPanel.add(lblPhoneNr, gbc_lblPhoneNr);
		}
		{
			textFieldPhone = new JTextField();
			textFieldPhone.setColumns(10);
			GridBagConstraints gbc_textFieldPhone = new GridBagConstraints();
			gbc_textFieldPhone.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldPhone.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPhone.gridx = 1;
			gbc_textFieldPhone.gridy = 2;
			contentPanel.add(textFieldPhone, gbc_textFieldPhone);
		}
		{
			JLabel lblAdress = new JLabel("Adresse:");
			GridBagConstraints gbc_lblAdress = new GridBagConstraints();
			gbc_lblAdress.anchor = GridBagConstraints.WEST;
			gbc_lblAdress.insets = new Insets(0, 0, 5, 5);
			gbc_lblAdress.gridx = 0;
			gbc_lblAdress.gridy = 3;
			contentPanel.add(lblAdress, gbc_lblAdress);
		}
		{
			textFieldAdress = new JTextField();
			textFieldAdress.setColumns(10);
			GridBagConstraints gbc_textFieldAdress = new GridBagConstraints();
			gbc_textFieldAdress.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldAdress.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAdress.gridx = 1;
			gbc_textFieldAdress.gridy = 3;
			contentPanel.add(textFieldAdress, gbc_textFieldAdress);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton BtnOpret = new JButton("Opret");
				BtnOpret.setActionCommand("OK");
				buttonPane.add(BtnOpret);
				getRootPane().setDefaultButton(BtnOpret);
			}
			{
				JButton cancelButton = new JButton("Tilbage");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						handleCancelButton();
					}
				});
				cancelButton.setActionCommand("Tilbage");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblTitel = new JLabel("Opret Kunde");
				lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 40));
				panel.add(lblTitel);
			}
		}
	}

	protected void handleCancelButton() {
		this.setVisible(false);
	}

}
