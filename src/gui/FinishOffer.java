package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.JScrollPane;
import java.awt.Choice;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.ScrollPane;

public class FinishOffer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel NorthPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnSgOrder;
	private JButton btnOdreNrButton;
	private JLabel lblNewLabel_1;
	private JButton btnOpdt;
	private JPanel SouthPane;
	private JButton btnSendFak;
	private JButton btnTilbage;
	private JButton btnNewButton_2;
	private JPanel CenterPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinishOffer frame = new FinishOffer();
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
	public FinishOffer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		NorthPane = new JPanel();
		contentPane.add(NorthPane, BorderLayout.NORTH);
		GridBagLayout gbl_northPane = new GridBagLayout();
		gbl_northPane.columnWidths = new int[]{127, 201, 83, 0};
		gbl_northPane.rowHeights = new int[]{23, 23, 23, 0};
		gbl_northPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_northPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		NorthPane.setLayout(gbl_northPane);
		
		lblNewLabel = new JLabel("Intast odre nr");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		NorthPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		NorthPane.add(textField, gbc_textField);
		
		btnSgOrder = new JButton("Søg odre nr");
		GridBagConstraints gbc_btnSgOrder = new GridBagConstraints();
		gbc_btnSgOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSgOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnSgOrder.anchor = GridBagConstraints.NORTH;
		gbc_btnSgOrder.gridx = 2;
		gbc_btnSgOrder.gridy = 0;
		NorthPane.add(btnSgOrder, gbc_btnSgOrder);
		
		btnOdreNrButton = new JButton("Tilføj odre nr");
		GridBagConstraints gbc_btnOdreNrButton = new GridBagConstraints();
		gbc_btnOdreNrButton.anchor = GridBagConstraints.NORTH;
		gbc_btnOdreNrButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOdreNrButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnOdreNrButton.gridx = 1;
		gbc_btnOdreNrButton.gridy = 1;
		NorthPane.add(btnOdreNrButton, gbc_btnOdreNrButton);
		
		lblNewLabel_1 = new JLabel("Ændre status");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		NorthPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		Choice choice = new Choice();
		GridBagConstraints gbc_choice = new GridBagConstraints();
		gbc_choice.fill = GridBagConstraints.HORIZONTAL;
		gbc_choice.insets = new Insets(0, 0, 5, 5);
		gbc_choice.gridx = 1;
		gbc_choice.gridy = 2;
		NorthPane.add(choice, gbc_choice);
		
		btnOpdt = new JButton("Opdater");
		GridBagConstraints gbc_btnOpdt = new GridBagConstraints();
		gbc_btnOpdt.insets = new Insets(0, 0, 5, 0);
		gbc_btnOpdt.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOpdt.anchor = GridBagConstraints.NORTH;
		gbc_btnOpdt.gridx = 2;
		gbc_btnOpdt.gridy = 2;
		NorthPane.add(btnOpdt, gbc_btnOpdt);
		
		SouthPane = new JPanel();
		contentPane.add(SouthPane, BorderLayout.SOUTH);
		SouthPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnSendFak = new JButton("Send faktura");
		SouthPane.add(btnSendFak);
		
		btnTilbage = new JButton("Gem");
		SouthPane.add(btnTilbage);
		
		btnNewButton_2 = new JButton("Tilbage");
		SouthPane.add(btnNewButton_2);
		
		CenterPane = new JPanel();
		contentPane.add(CenterPane, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		CenterPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
