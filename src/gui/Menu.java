package gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import control.OrderController;
import tui.TryMe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JLayeredPane layeredOfferPane;
	private JButton btnCreateOffer;
	private JButton btnChangeOfferStatus;
	private JButton btnReturnButton;
	private JButton btnNormaltSale;
	private JLayeredPane layeredLeasingPane;
	private JButton btnCreateLeasing;
	private JButton btnReturnLeasingButton;
	private JButton btnAddNewMachineButton;
	private JButton btnSearchLeasingButton;
	private JLayeredPane layeredEmployeePane;
	private JButton btnCreateEmployee;
	private JButton btnSearchEmployee;
	private JButton btnAddEmployee;
	private JButton btnRemoveEmployee;
	private JLayeredPane layeredCustomerPane;
	private JButton btnCreateCustomer;
	private JButton btnSearchCustomer;
	private JButton btnAddCustomer;
	private JButton btnRemoveCustomer;
	private JButton btnSetCustomerCategory;
	private JLayeredPane layeredInventoryPane;
	private JButton btnFindProduct;
	private JButton btnOrderProduct;
	private JButton btnInventoryCount;
	private JLayeredPane layeredStatisticPane;
	private JButton btnEmployeeStatistic;
	private JButton btnCustomerStatistic;
	private JButton btnInventoryStatistic;
	private JButton btnLogud;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		TryMe.addData();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 438, 227);
		contentPane.add(tabbedPane);
		
		layeredOfferPane = new JLayeredPane();
		tabbedPane.addTab("Salg", null, layeredOfferPane, null);
		
		btnCreateOffer = new JButton("Opret tilbud");
		btnCreateOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleOpretTilbud();
			}
		});
		btnCreateOffer.setBounds(10, 44, 172, 23);
		layeredOfferPane.add(btnCreateOffer);
		
		btnChangeOfferStatus = new JButton("Færdiggør tilbud");
		btnChangeOfferStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleFærdiggørbutton();
			}
		});
		btnChangeOfferStatus.setBounds(10, 78, 172, 23);
		layeredOfferPane.add(btnChangeOfferStatus);
		
		btnReturnButton = new JButton("Returner vare ");
		btnReturnButton.setBounds(10, 112, 172, 23);
		layeredOfferPane.add(btnReturnButton);
		
		btnNormaltSale = new JButton("Normalt salg");
		btnNormaltSale.setBounds(10, 11, 172, 23);
		layeredOfferPane.add(btnNormaltSale);
		
		layeredLeasingPane = new JLayeredPane();
		tabbedPane.addTab("Leasing", null, layeredLeasingPane, null);
		
		btnCreateLeasing = new JButton("Udlån maskine");
		btnCreateLeasing.setBounds(10, 11, 173, 23);
		layeredLeasingPane.add(btnCreateLeasing);
		
		btnReturnLeasingButton = new JButton("Returner maskine");
		btnReturnLeasingButton.setBounds(10, 45, 173, 23);
		layeredLeasingPane.add(btnReturnLeasingButton);
		
		btnAddNewMachineButton = new JButton("Tilføj ny maskine");
		btnAddNewMachineButton.setBounds(10, 79, 173, 23);
		layeredLeasingPane.add(btnAddNewMachineButton);
		
		btnSearchLeasingButton = new JButton("Gennemse maskiner");
		btnSearchLeasingButton.setBounds(10, 113, 173, 23);
		layeredLeasingPane.add(btnSearchLeasingButton);
		
		layeredEmployeePane = new JLayeredPane();
		tabbedPane.addTab("Medarbejder", null, layeredEmployeePane, null);
		
		btnCreateEmployee = new JButton("Opret Medarbejder");
		btnCreateEmployee.setBounds(10, 11, 173, 23);
		layeredEmployeePane.add(btnCreateEmployee);
		
		btnSearchEmployee = new JButton("Gennemse medarbejdere");
		btnSearchEmployee.setBounds(10, 45, 173, 23);
		layeredEmployeePane.add(btnSearchEmployee);
		
		btnAddEmployee = new JButton("Tilføj ny medarbejder");
		btnAddEmployee.setBounds(10, 79, 173, 23);
		layeredEmployeePane.add(btnAddEmployee);
		
		btnRemoveEmployee = new JButton("Fjern medarbejder");
		btnRemoveEmployee.setBounds(10, 113, 173, 23);
		layeredEmployeePane.add(btnRemoveEmployee);
		
		layeredCustomerPane = new JLayeredPane();
		tabbedPane.addTab("Kunde", null, layeredCustomerPane, null);
		
		btnCreateCustomer = new JButton("Opret kunde ");
		btnCreateCustomer.setBounds(10, 11, 173, 23);
		layeredCustomerPane.add(btnCreateCustomer);
		
		btnSearchCustomer = new JButton("Gennemse kunde");
		btnSearchCustomer.setBounds(10, 45, 173, 23);
		layeredCustomerPane.add(btnSearchCustomer);
		
		btnAddCustomer = new JButton("Tilføj ny kunde");
		btnAddCustomer.setBounds(10, 79, 173, 23);
		layeredCustomerPane.add(btnAddCustomer);
		
		btnRemoveCustomer = new JButton("Fjern kunde");
		btnRemoveCustomer.setBounds(10, 113, 173, 23);
		layeredCustomerPane.add(btnRemoveCustomer);
		
		btnSetCustomerCategory = new JButton("Angiv kunde kategori");
		btnSetCustomerCategory.setBounds(10, 147, 173, 23);
		layeredCustomerPane.add(btnSetCustomerCategory);
		
		layeredInventoryPane = new JLayeredPane();
		tabbedPane.addTab("Lager", null, layeredInventoryPane, null);
		
		btnFindProduct = new JButton("Find vare");
		btnFindProduct.setBounds(10, 11, 173, 23);
		layeredInventoryPane.add(btnFindProduct);
		
		btnOrderProduct = new JButton("Bestil vare ");
		btnOrderProduct.setBounds(10, 45, 173, 23);
		layeredInventoryPane.add(btnOrderProduct);
		
		btnInventoryCount = new JButton("Lager optælling ");
		btnInventoryCount.setBounds(10, 79, 173, 23);
		layeredInventoryPane.add(btnInventoryCount);
		
		layeredStatisticPane = new JLayeredPane();
		tabbedPane.addTab("Statistik", null, layeredStatisticPane, null);
		
		btnEmployeeStatistic = new JButton("Medarbejder statestik");
		btnEmployeeStatistic.setBounds(10, 11, 173, 23);
		layeredStatisticPane.add(btnEmployeeStatistic);
		
		btnCustomerStatistic = new JButton("Kunde statestik");
		btnCustomerStatistic.setBounds(10, 45, 173, 23);
		layeredStatisticPane.add(btnCustomerStatistic);
		
		btnInventoryStatistic = new JButton("Lager statestik ");
		btnInventoryStatistic.setBounds(10, 79, 173, 23);
		layeredStatisticPane.add(btnInventoryStatistic);
		
		btnLogud = new JButton("Logud");
		btnLogud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logOut();
			}
		});
		btnLogud.setBounds(339, 242, 89, 23);
		contentPane.add(btnLogud);
		
	
	}

	private void handleFærdiggørbutton() {
		// TODO Auto-generated method stub
		FinishOffer fo = new FinishOffer();
		fo.setVisible(true);
	}

	private void handleOpretTilbud() {
		// TODO Auto-generated method stub
		CreateOffer co = new CreateOffer();
		co.setVisible(true);
		
		
	}

	private void logOut() {
		Login login = new Login();
		login.setVisible(true);
        Menu.this.setVisible(false);
        Menu.this.dispose();
		
	}

}
