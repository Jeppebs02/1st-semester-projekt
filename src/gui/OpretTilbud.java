package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OpretTilbud extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textAntalField;
	private JTextField textStregkodeField;
	private JTextField textKundeIDField;
	private JTable table;
	private JLabel lblStregkodeLabel;
	private JLabel lblAntalLabel;
	private JLabel lblKundeIDLabel;
	private JButton btnSøgProduktButton;
	private JButton btnSøgKundeIDButton;
	private JButton btnTilføjProduktButton;
	private JScrollPane scrollPane;
	private JLabel lblOrdreLabel;
	private JLabel lblTotalPrisLabel;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
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
		setBounds(100, 100, 373, 516);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblStregkodeLabel = new JLabel("Stregkode");
			lblStregkodeLabel.setBounds(24, 23, 66, 13);
			contentPanel.add(lblStregkodeLabel);
		}
		
		lblAntalLabel = new JLabel("Antal");
		lblAntalLabel.setBounds(24, 54, 66, 13);
		contentPanel.add(lblAntalLabel);
		
		lblKundeIDLabel = new JLabel("Customer ID");
		lblKundeIDLabel.setBounds(24, 402, 72, 13);
		contentPanel.add(lblKundeIDLabel);
		
		textAntalField = new JTextField();
		textAntalField.setBounds(100, 51, 96, 19);
		contentPanel.add(textAntalField);
		textAntalField.setColumns(10);
		
		textStregkodeField = new JTextField();
		textStregkodeField.setBounds(100, 20, 96, 19);
		contentPanel.add(textStregkodeField);
		textStregkodeField.setColumns(10);
		
		btnSøgProduktButton = new JButton("Søg produkt");
		btnSøgProduktButton.setBounds(221, 19, 111, 21);
		contentPanel.add(btnSøgProduktButton);
		
		textKundeIDField = new JTextField();
		textKundeIDField.setColumns(10);
		textKundeIDField.setBounds(100, 399, 96, 19);
		contentPanel.add(textKundeIDField);
		
		btnSøgKundeIDButton = new JButton("Søg Kunde");
		btnSøgKundeIDButton.setBounds(221, 398, 111, 21);
		contentPanel.add(btnSøgKundeIDButton);
		
		btnTilføjProduktButton = new JButton("Tilføj produkt");
		btnTilføjProduktButton.setBounds(221, 79, 111, 21);
		contentPanel.add(btnTilføjProduktButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 143, 308, 175);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblOrdreLabel = new JLabel("Ordre");
		lblOrdreLabel.setBounds(24, 120, 66, 13);
		contentPanel.add(lblOrdreLabel);
		
		lblTotalPrisLabel = new JLabel("Total pris:");
		lblTotalPrisLabel.setBounds(24, 328, 66, 13);
		contentPanel.add(lblTotalPrisLabel);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
