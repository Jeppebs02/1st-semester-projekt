import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

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
		setBounds(450, 300, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel label = new JLabel("");
		contentPane.add(label);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Login på systemet");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1);
		
		JLabel lblUsername = new JLabel("Employe ID");
		contentPane.add(lblUsername);
		
		JLabel label_2 = new JLabel("");
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		contentPane.add(textField);
		
		JLabel label_3 = new JLabel("");
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		contentPane.add(label_5);
		
		JLabel lblNewLabel = new JLabel("Password");
		contentPane.add(lblNewLabel);
		
		JLabel label_6 = new JLabel("");
		contentPane.add(label_6);
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField);
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
                logIn();
			}
		});
		
		JLabel label_7 = new JLabel("");
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("");
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("");
		contentPane.add(label_11);
		contentPane.add(btnNewButton);
	}

	protected void logIn() {
		//Check om username og password er i system 
		Menu menu = new Menu();
		menu.setVisible(true);
        Login.this.setVisible(false);
        Login.this.dispose();
		
	}
	
	
	}


