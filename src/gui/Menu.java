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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;


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
	private JPanel panel;
	private JButton btnLogOut;
	private JButton btnUpdateProduct;
	
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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		layeredOfferPane = new JLayeredPane();
		tabbedPane.addTab("Salg", null, layeredOfferPane, null);
		GridBagLayout gbl_layeredOfferPane = new GridBagLayout();
		gbl_layeredOfferPane.columnWidths = new int[]{172, 0};
		gbl_layeredOfferPane.rowHeights = new int[]{23, 23, 23, 23, 0};
		gbl_layeredOfferPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_layeredOfferPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		layeredOfferPane.setLayout(gbl_layeredOfferPane);
		
		btnCreateOffer = new JButton("Opret tilbud");
		btnCreateOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleOpretTilbud();
			}
		});
		
		btnNormaltSale = new JButton("Normalt salg");
		GridBagConstraints gbc_btnNormaltSale = new GridBagConstraints();
		gbc_btnNormaltSale.anchor = GridBagConstraints.NORTH;
		gbc_btnNormaltSale.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNormaltSale.insets = new Insets(0, 0, 5, 0);
		gbc_btnNormaltSale.gridx = 0;
		gbc_btnNormaltSale.gridy = 0;
		layeredOfferPane.add(btnNormaltSale, gbc_btnNormaltSale);
		GridBagConstraints gbc_btnCreateOffer = new GridBagConstraints();
		gbc_btnCreateOffer.anchor = GridBagConstraints.NORTH;
		gbc_btnCreateOffer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateOffer.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateOffer.gridx = 0;
		gbc_btnCreateOffer.gridy = 1;
		layeredOfferPane.add(btnCreateOffer, gbc_btnCreateOffer);
		
		btnChangeOfferStatus = new JButton("Færdiggør tilbud");
		btnChangeOfferStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleFærdiggørbutton();
			}
		});
		GridBagConstraints gbc_btnChangeOfferStatus = new GridBagConstraints();
		gbc_btnChangeOfferStatus.anchor = GridBagConstraints.NORTH;
		gbc_btnChangeOfferStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChangeOfferStatus.insets = new Insets(0, 0, 5, 0);
		gbc_btnChangeOfferStatus.gridx = 0;
		gbc_btnChangeOfferStatus.gridy = 2;
		layeredOfferPane.add(btnChangeOfferStatus, gbc_btnChangeOfferStatus);
		
		btnReturnButton = new JButton("Returner vare ");
		GridBagConstraints gbc_btnReturnButton = new GridBagConstraints();
		gbc_btnReturnButton.anchor = GridBagConstraints.NORTH;
		gbc_btnReturnButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReturnButton.gridx = 0;
		gbc_btnReturnButton.gridy = 3;
		layeredOfferPane.add(btnReturnButton, gbc_btnReturnButton);
		
		layeredLeasingPane = new JLayeredPane();
		tabbedPane.addTab("Leasing", null, layeredLeasingPane, null);
		GridBagLayout gbl_layeredLeasingPane = new GridBagLayout();
		gbl_layeredLeasingPane.columnWidths = new int[]{173, 0};
		gbl_layeredLeasingPane.rowHeights = new int[]{23, 23, 23, 23, 0};
		gbl_layeredLeasingPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_layeredLeasingPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		layeredLeasingPane.setLayout(gbl_layeredLeasingPane);
		
		btnCreateLeasing = new JButton("Udlån maskine");
		GridBagConstraints gbc_btnCreateLeasing = new GridBagConstraints();
		gbc_btnCreateLeasing.anchor = GridBagConstraints.NORTH;
		gbc_btnCreateLeasing.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateLeasing.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateLeasing.gridx = 0;
		gbc_btnCreateLeasing.gridy = 0;
		layeredLeasingPane.add(btnCreateLeasing, gbc_btnCreateLeasing);
		
		btnReturnLeasingButton = new JButton("Returner maskine");
		GridBagConstraints gbc_btnReturnLeasingButton = new GridBagConstraints();
		gbc_btnReturnLeasingButton.anchor = GridBagConstraints.NORTH;
		gbc_btnReturnLeasingButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReturnLeasingButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnReturnLeasingButton.gridx = 0;
		gbc_btnReturnLeasingButton.gridy = 1;
		layeredLeasingPane.add(btnReturnLeasingButton, gbc_btnReturnLeasingButton);
		
		btnAddNewMachineButton = new JButton("Tilføj ny maskine");
		GridBagConstraints gbc_btnAddNewMachineButton = new GridBagConstraints();
		gbc_btnAddNewMachineButton.anchor = GridBagConstraints.NORTH;
		gbc_btnAddNewMachineButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddNewMachineButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddNewMachineButton.gridx = 0;
		gbc_btnAddNewMachineButton.gridy = 2;
		layeredLeasingPane.add(btnAddNewMachineButton, gbc_btnAddNewMachineButton);
		
		btnSearchLeasingButton = new JButton("Gennemse maskiner");
		GridBagConstraints gbc_btnSearchLeasingButton = new GridBagConstraints();
		gbc_btnSearchLeasingButton.anchor = GridBagConstraints.NORTH;
		gbc_btnSearchLeasingButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSearchLeasingButton.gridx = 0;
		gbc_btnSearchLeasingButton.gridy = 3;
		layeredLeasingPane.add(btnSearchLeasingButton, gbc_btnSearchLeasingButton);
		
		layeredEmployeePane = new JLayeredPane();
		tabbedPane.addTab("Medarbejder", null, layeredEmployeePane, null);
		GridBagLayout gbl_layeredEmployeePane = new GridBagLayout();
		gbl_layeredEmployeePane.columnWidths = new int[]{173, 0};
		gbl_layeredEmployeePane.rowHeights = new int[]{23, 23, 23, 23, 0};
		gbl_layeredEmployeePane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_layeredEmployeePane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		layeredEmployeePane.setLayout(gbl_layeredEmployeePane);
		
		btnCreateEmployee = new JButton("Opret Medarbejder");
		GridBagConstraints gbc_btnCreateEmployee = new GridBagConstraints();
		gbc_btnCreateEmployee.anchor = GridBagConstraints.NORTH;
		gbc_btnCreateEmployee.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateEmployee.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateEmployee.gridx = 0;
		gbc_btnCreateEmployee.gridy = 0;
		layeredEmployeePane.add(btnCreateEmployee, gbc_btnCreateEmployee);
		
		btnSearchEmployee = new JButton("Gennemse medarbejdere");
		GridBagConstraints gbc_btnSearchEmployee = new GridBagConstraints();
		gbc_btnSearchEmployee.anchor = GridBagConstraints.NORTH;
		gbc_btnSearchEmployee.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSearchEmployee.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearchEmployee.gridx = 0;
		gbc_btnSearchEmployee.gridy = 1;
		layeredEmployeePane.add(btnSearchEmployee, gbc_btnSearchEmployee);
		
		btnAddEmployee = new JButton("Tilføj ny medarbejder");
		GridBagConstraints gbc_btnAddEmployee = new GridBagConstraints();
		gbc_btnAddEmployee.anchor = GridBagConstraints.NORTH;
		gbc_btnAddEmployee.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddEmployee.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddEmployee.gridx = 0;
		gbc_btnAddEmployee.gridy = 2;
		layeredEmployeePane.add(btnAddEmployee, gbc_btnAddEmployee);
		
		btnRemoveEmployee = new JButton("Fjern medarbejder");
		GridBagConstraints gbc_btnRemoveEmployee = new GridBagConstraints();
		gbc_btnRemoveEmployee.anchor = GridBagConstraints.NORTH;
		gbc_btnRemoveEmployee.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemoveEmployee.gridx = 0;
		gbc_btnRemoveEmployee.gridy = 3;
		layeredEmployeePane.add(btnRemoveEmployee, gbc_btnRemoveEmployee);
		
		layeredCustomerPane = new JLayeredPane();
		tabbedPane.addTab("Kunde", null, layeredCustomerPane, null);
		GridBagLayout gbl_layeredCustomerPane = new GridBagLayout();
		gbl_layeredCustomerPane.columnWidths = new int[]{173, 0};
		gbl_layeredCustomerPane.rowHeights = new int[]{23, 23, 23, 23, 0};
		gbl_layeredCustomerPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_layeredCustomerPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		layeredCustomerPane.setLayout(gbl_layeredCustomerPane);
		
		btnCreateCustomer = new JButton("Opret kunde ");
		btnCreateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HandleOpretKunde();
			}
		});
		GridBagConstraints gbc_btnCreateCustomer = new GridBagConstraints();
		gbc_btnCreateCustomer.anchor = GridBagConstraints.NORTH;
		gbc_btnCreateCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateCustomer.gridx = 0;
		gbc_btnCreateCustomer.gridy = 0;
		layeredCustomerPane.add(btnCreateCustomer, gbc_btnCreateCustomer);
		
		btnSearchCustomer = new JButton("Gennemse kunde");
		btnSearchCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleGennemseKunde();
			}
		});
		GridBagConstraints gbc_btnSearchCustomer = new GridBagConstraints();
		gbc_btnSearchCustomer.anchor = GridBagConstraints.NORTH;
		gbc_btnSearchCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSearchCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearchCustomer.gridx = 0;
		gbc_btnSearchCustomer.gridy = 1;
		layeredCustomerPane.add(btnSearchCustomer, gbc_btnSearchCustomer);
		
		btnRemoveCustomer = new JButton("Fjern kunde");
		btnRemoveCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HandleFjernKunde();
			}
		});
		GridBagConstraints gbc_btnRemoveCustomer = new GridBagConstraints();
		gbc_btnRemoveCustomer.anchor = GridBagConstraints.NORTH;
		gbc_btnRemoveCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemoveCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemoveCustomer.gridx = 0;
		gbc_btnRemoveCustomer.gridy = 2;
		layeredCustomerPane.add(btnRemoveCustomer, gbc_btnRemoveCustomer);
		
		btnSetCustomerCategory = new JButton("Angiv kunde kategori");
		GridBagConstraints gbc_btnSetCustomerCategory = new GridBagConstraints();
		gbc_btnSetCustomerCategory.anchor = GridBagConstraints.NORTH;
		gbc_btnSetCustomerCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSetCustomerCategory.gridx = 0;
		gbc_btnSetCustomerCategory.gridy = 3;
		layeredCustomerPane.add(btnSetCustomerCategory, gbc_btnSetCustomerCategory);
		
		layeredInventoryPane = new JLayeredPane();
		tabbedPane.addTab("Lager", null, layeredInventoryPane, null);
		GridBagLayout gbl_layeredInventoryPane = new GridBagLayout();
		gbl_layeredInventoryPane.columnWidths = new int[]{173, 0};
		gbl_layeredInventoryPane.rowHeights = new int[]{23, 23, 23, 0, 0};
		gbl_layeredInventoryPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_layeredInventoryPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		layeredInventoryPane.setLayout(gbl_layeredInventoryPane);
		
		btnFindProduct = new JButton("Find vare");
		GridBagConstraints gbc_btnFindProduct = new GridBagConstraints();
		gbc_btnFindProduct.anchor = GridBagConstraints.NORTH;
		gbc_btnFindProduct.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFindProduct.insets = new Insets(0, 0, 5, 0);
		gbc_btnFindProduct.gridx = 0;
		gbc_btnFindProduct.gridy = 0;
		layeredInventoryPane.add(btnFindProduct, gbc_btnFindProduct);
		
		btnOrderProduct = new JButton("Bestil vare ");
		GridBagConstraints gbc_btnOrderProduct = new GridBagConstraints();
		gbc_btnOrderProduct.anchor = GridBagConstraints.NORTH;
		gbc_btnOrderProduct.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOrderProduct.insets = new Insets(0, 0, 5, 0);
		gbc_btnOrderProduct.gridx = 0;
		gbc_btnOrderProduct.gridy = 1;
		layeredInventoryPane.add(btnOrderProduct, gbc_btnOrderProduct);
		
		btnUpdateProduct = new JButton("Opdater vare");
		GridBagConstraints gbc_btnUpdateProduct = new GridBagConstraints();
		gbc_btnUpdateProduct.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUpdateProduct.anchor = GridBagConstraints.NORTH;
		gbc_btnUpdateProduct.insets = new Insets(0, 0, 5, 0);
		gbc_btnUpdateProduct.gridx = 0;
		gbc_btnUpdateProduct.gridy = 2;
		layeredInventoryPane.add(btnUpdateProduct, gbc_btnUpdateProduct);
		
		btnInventoryCount = new JButton("Lager optælling ");
		GridBagConstraints gbc_btnInventoryCount = new GridBagConstraints();
		gbc_btnInventoryCount.anchor = GridBagConstraints.NORTH;
		gbc_btnInventoryCount.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInventoryCount.gridx = 0;
		gbc_btnInventoryCount.gridy = 3;
		layeredInventoryPane.add(btnInventoryCount, gbc_btnInventoryCount);
		
		layeredStatisticPane = new JLayeredPane();
		tabbedPane.addTab("Statistik", null, layeredStatisticPane, null);
		GridBagLayout gbl_layeredStatisticPane = new GridBagLayout();
		gbl_layeredStatisticPane.columnWidths = new int[]{173, 0};
		gbl_layeredStatisticPane.rowHeights = new int[]{23, 23, 23, 0};
		gbl_layeredStatisticPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_layeredStatisticPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		layeredStatisticPane.setLayout(gbl_layeredStatisticPane);
		
		btnEmployeeStatistic = new JButton("Medarbejder statestik");
		GridBagConstraints gbc_btnEmployeeStatistic = new GridBagConstraints();
		gbc_btnEmployeeStatistic.anchor = GridBagConstraints.NORTH;
		gbc_btnEmployeeStatistic.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEmployeeStatistic.insets = new Insets(0, 0, 5, 0);
		gbc_btnEmployeeStatistic.gridx = 0;
		gbc_btnEmployeeStatistic.gridy = 0;
		layeredStatisticPane.add(btnEmployeeStatistic, gbc_btnEmployeeStatistic);
		
		btnCustomerStatistic = new JButton("Kunde statestik");
		GridBagConstraints gbc_btnCustomerStatistic = new GridBagConstraints();
		gbc_btnCustomerStatistic.anchor = GridBagConstraints.NORTH;
		gbc_btnCustomerStatistic.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCustomerStatistic.insets = new Insets(0, 0, 5, 0);
		gbc_btnCustomerStatistic.gridx = 0;
		gbc_btnCustomerStatistic.gridy = 1;
		layeredStatisticPane.add(btnCustomerStatistic, gbc_btnCustomerStatistic);
		
		btnInventoryStatistic = new JButton("Lager statestik ");
		GridBagConstraints gbc_btnInventoryStatistic = new GridBagConstraints();
		gbc_btnInventoryStatistic.anchor = GridBagConstraints.NORTH;
		gbc_btnInventoryStatistic.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInventoryStatistic.gridx = 0;
		gbc_btnInventoryStatistic.gridy = 2;
		layeredStatisticPane.add(btnInventoryStatistic, gbc_btnInventoryStatistic);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{335, 89, 0};
		gbl_panel.rowHeights = new int[]{23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnLogOut = new JButton("Log ud");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logOut();
			}
		});
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnLogOut.gridx = 1;
		gbc_btnLogOut.gridy = 0;
		panel.add(btnLogOut, gbc_btnLogOut);
		
	
	}

	private void HandleOpretKunde() {
		NewCustomer nc = new NewCustomer();
		nc.setVisible(true);
		
	}

	private void HandleFjernKunde() {
		DeleteCustomer dc = new DeleteCustomer();
		dc.setVisible(true);
		
	}

	private void handleGennemseKunde() {
		SearchCustomer sc = new SearchCustomer();
		sc.setVisible(true);
		
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
