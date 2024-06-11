package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.LoginController;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel southPanel;
	private JButton btnLogin;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JPanel centerPanel;
	private JLabel lblLoginHeader;
	private JPanel northPanel;
	private GridBagLayout gbl_centerPanel;
	private GridBagConstraints gbc_lblUsername;
	private GridBagConstraints gbc_usernameField;
	private GridBagConstraints gbc_lblPassword;
	private GridBagConstraints gbc_passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 300, 562, 300);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		lblLoginHeader = new JLabel("Login på systemet");
		lblLoginHeader.setFont(new Font("Tahoma", Font.PLAIN, 30));
		northPanel.add(lblLoginHeader);
		
		centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		gbl_centerPanel = new GridBagLayout();
		gbl_centerPanel.columnWidths = new int[]{218, 218, 0};
		gbl_centerPanel.rowHeights = new int[]{65, 22, 65, 0};
		gbl_centerPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerPanel.setLayout(gbl_centerPanel);
		
		lblUsername = new JLabel("Employe ID");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 22));
		gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.VERTICAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		centerPanel.add(lblUsername, gbc_lblUsername);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setColumns(10);
		gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.fill = GridBagConstraints.BOTH;
		gbc_usernameField.insets = new Insets(0, 0, 5, 0);
		gbc_usernameField.gridx = 1;
		gbc_usernameField.gridy = 0;
		gbc_usernameField.weightx = 1.0;
		centerPanel.add(textField, gbc_usernameField);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.VERTICAL;
		gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 2;
		centerPanel.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 2;
		centerPanel.add(passwordField, gbc_passwordField);
		
		southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLoginButton();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		southPanel.add(btnLogin);
	}

	private void handleLoginButton() {
		// TODO Write Login method. Use LoginController to check for employee login.
		
		String username = textField.getText();
		String password = passwordField.getText();
		
		LoginController lc = new LoginController();
		
		if(lc.authenticateEmployee(username, password)) {
			Menu menu = new Menu();
			menu.setVisible(true);
			
			this.setVisible(false);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Login failed, try again.");
		}
		
		
		
		
		
	}
	
	
	}


