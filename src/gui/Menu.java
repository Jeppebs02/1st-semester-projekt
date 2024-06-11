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
	private JLayeredPane layeredTilbudPane;
	private JButton btnOpretTilbud;
	private JButton btnFærdiggørTilbud;
	private JButton btnReturnButton;
	private JButton btnNormaltSalg;
	private JLayeredPane layeredLeasingPane;
	private JButton btnUdlnMaskine;
	private JButton btnReturnMachineButton;
	private JButton btnAddNewMachineButton;
	private JButton btnSearchMachineButton;
	private JLayeredPane layeredMedarbejderPane;
	private JButton btnOpretMedarbejder;
	private JButton btnSearchMedarbejder;
	private JButton btnAddMedarbejder;
	private JButton btnRemoveMedarbejder;
	private JLayeredPane layeredCustomerPane;
	private JButton btnCreateKunde;
	private JButton btnSearchKunde;
	private JButton btnAddKunde;
	private JButton btnRemoveKunde;
	private JButton btnSetKundeKategori;
	private JLayeredPane layeredLagerPane;
	private JButton btnFindVare;
	private JButton btnBestilVare;
	private JButton btnLagerOptælling;
	private JLayeredPane layeredStatestikPane;
	private JButton btnMedarbejderStatestik;
	private JButton btnKundeStatestik;
	private JButton btnLagerStatestik;
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
		
		layeredTilbudPane = new JLayeredPane();
		tabbedPane.addTab("Salg", null, layeredTilbudPane, null);
		
		btnOpretTilbud = new JButton("Opret tilbud");
		btnOpretTilbud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleOpretTilbud();
			}
		});
		btnOpretTilbud.setBounds(10, 44, 172, 23);
		layeredTilbudPane.add(btnOpretTilbud);
		
		btnFærdiggørTilbud = new JButton("Færdiggør tilbud");
		btnFærdiggørTilbud.setBounds(10, 78, 172, 23);
		layeredTilbudPane.add(btnFærdiggørTilbud);
		
		btnReturnButton = new JButton("Returner vare ");
		btnReturnButton.setBounds(10, 112, 172, 23);
		layeredTilbudPane.add(btnReturnButton);
		
		btnNormaltSalg = new JButton("Normalt salg");
		btnNormaltSalg.setBounds(10, 11, 172, 23);
		layeredTilbudPane.add(btnNormaltSalg);
		
		layeredLeasingPane = new JLayeredPane();
		tabbedPane.addTab("Leasing", null, layeredLeasingPane, null);
		
		btnUdlnMaskine = new JButton("Udlån maskine");
		btnUdlnMaskine.setBounds(10, 11, 173, 23);
		layeredLeasingPane.add(btnUdlnMaskine);
		
		btnReturnMachineButton = new JButton("Returner maskine");
		btnReturnMachineButton.setBounds(10, 45, 173, 23);
		layeredLeasingPane.add(btnReturnMachineButton);
		
		btnAddNewMachineButton = new JButton("Tilføj ny maskine");
		btnAddNewMachineButton.setBounds(10, 79, 173, 23);
		layeredLeasingPane.add(btnAddNewMachineButton);
		
		btnSearchMachineButton = new JButton("Gennemse maskiner");
		btnSearchMachineButton.setBounds(10, 113, 173, 23);
		layeredLeasingPane.add(btnSearchMachineButton);
		
		layeredMedarbejderPane = new JLayeredPane();
		tabbedPane.addTab("Medarbejder", null, layeredMedarbejderPane, null);
		
		btnOpretMedarbejder = new JButton("Opret Medarbejder");
		btnOpretMedarbejder.setBounds(10, 11, 173, 23);
		layeredMedarbejderPane.add(btnOpretMedarbejder);
		
		btnSearchMedarbejder = new JButton("Gennemse medarbejdere");
		btnSearchMedarbejder.setBounds(10, 45, 173, 23);
		layeredMedarbejderPane.add(btnSearchMedarbejder);
		
		btnAddMedarbejder = new JButton("Tilføj ny medarbejder");
		btnAddMedarbejder.setBounds(10, 79, 173, 23);
		layeredMedarbejderPane.add(btnAddMedarbejder);
		
		btnRemoveMedarbejder = new JButton("Fjern medarbejder");
		btnRemoveMedarbejder.setBounds(10, 113, 173, 23);
		layeredMedarbejderPane.add(btnRemoveMedarbejder);
		
		layeredCustomerPane = new JLayeredPane();
		tabbedPane.addTab("Kunde", null, layeredCustomerPane, null);
		
		btnCreateKunde = new JButton("Opret kunde ");
		btnCreateKunde.setBounds(10, 11, 173, 23);
		layeredCustomerPane.add(btnCreateKunde);
		
		btnSearchKunde = new JButton("Gennemse kunde");
		btnSearchKunde.setBounds(10, 45, 173, 23);
		layeredCustomerPane.add(btnSearchKunde);
		
		btnAddKunde = new JButton("Tilføj ny kunde");
		btnAddKunde.setBounds(10, 79, 173, 23);
		layeredCustomerPane.add(btnAddKunde);
		
		btnRemoveKunde = new JButton("Fjern kunde");
		btnRemoveKunde.setBounds(10, 113, 173, 23);
		layeredCustomerPane.add(btnRemoveKunde);
		
		btnSetKundeKategori = new JButton("Angiv kunde kategori");
		btnSetKundeKategori.setBounds(10, 147, 173, 23);
		layeredCustomerPane.add(btnSetKundeKategori);
		
		layeredLagerPane = new JLayeredPane();
		tabbedPane.addTab("Lager", null, layeredLagerPane, null);
		
		btnFindVare = new JButton("Find vare");
		btnFindVare.setBounds(10, 11, 173, 23);
		layeredLagerPane.add(btnFindVare);
		
		btnBestilVare = new JButton("Bestil vare ");
		btnBestilVare.setBounds(10, 45, 173, 23);
		layeredLagerPane.add(btnBestilVare);
		
		btnLagerOptælling = new JButton("Lager optælling ");
		btnLagerOptælling.setBounds(10, 79, 173, 23);
		layeredLagerPane.add(btnLagerOptælling);
		
		layeredStatestikPane = new JLayeredPane();
		tabbedPane.addTab("Statistik", null, layeredStatestikPane, null);
		
		btnMedarbejderStatestik = new JButton("Medarbejder statestik");
		btnMedarbejderStatestik.setBounds(10, 11, 173, 23);
		layeredStatestikPane.add(btnMedarbejderStatestik);
		
		btnKundeStatestik = new JButton("Kunde statestik");
		btnKundeStatestik.setBounds(10, 45, 173, 23);
		layeredStatestikPane.add(btnKundeStatestik);
		
		btnLagerStatestik = new JButton("Lager statestik ");
		btnLagerStatestik.setBounds(10, 79, 173, 23);
		layeredStatestikPane.add(btnLagerStatestik);
		
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

	private void handleOpretTilbud() {
		// TODO Auto-generated method stub
		OpretTilbud ot = new OpretTilbud();
		ot.setVisible(true);
		
		
	}

	private void logOut() {
		Login login = new Login();
		login.setVisible(true);
        Menu.this.setVisible(false);
        Menu.this.dispose();
		
	}

}
