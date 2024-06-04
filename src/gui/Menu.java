package gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 438, 227);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Salg", null, layeredPane, null);
		
		JButton opretTilbud = new JButton("Opret tilbud");
		opretTilbud.setBounds(10, 44, 172, 23);
		layeredPane.add(opretTilbud);
		
		JButton færdiggørTilbud = new JButton("Færdiggør tilbud");
		færdiggørTilbud.setBounds(10, 78, 172, 23);
		layeredPane.add(færdiggørTilbud);
		
		JButton btnNewButton_1_5 = new JButton("Returner vare ");
		btnNewButton_1_5.setBounds(10, 112, 172, 23);
		layeredPane.add(btnNewButton_1_5);
		
		JButton btnNormaltSalg = new JButton("Normalt salg");
		btnNormaltSalg.setBounds(10, 11, 172, 23);
		layeredPane.add(btnNormaltSalg);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		tabbedPane.addTab("Leasing", null, layeredPane_3, null);
		
		JButton btnUdlnMaskine = new JButton("Udlån maskine");
		btnUdlnMaskine.setBounds(10, 11, 173, 23);
		layeredPane_3.add(btnUdlnMaskine);
		
		JButton btnNewButton_1_3 = new JButton("Returner maskine");
		btnNewButton_1_3.setBounds(10, 45, 173, 23);
		layeredPane_3.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_5_1 = new JButton("Tilføj ny maskine");
		btnNewButton_1_5_1.setBounds(10, 79, 173, 23);
		layeredPane_3.add(btnNewButton_1_5_1);
		
		JButton btnNewButton_1_5_1_1 = new JButton("Gennemse maskiner");
		btnNewButton_1_5_1_1.setBounds(10, 113, 173, 23);
		layeredPane_3.add(btnNewButton_1_5_1_1);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Medarbejder", null, layeredPane_1, null);
		
		JButton btnUdlnMaskine_1 = new JButton("Opret Medarbejder");
		btnUdlnMaskine_1.setBounds(10, 11, 173, 23);
		layeredPane_1.add(btnUdlnMaskine_1);
		
		JButton btnNewButton_1_3_1 = new JButton("Gennemse medarbejdere");
		btnNewButton_1_3_1.setBounds(10, 45, 173, 23);
		layeredPane_1.add(btnNewButton_1_3_1);
		
		JButton btnNewButton_1_5_1_2 = new JButton("Tilføj ny medarbejder");
		btnNewButton_1_5_1_2.setBounds(10, 79, 173, 23);
		layeredPane_1.add(btnNewButton_1_5_1_2);
		
		JButton btnNewButton_1_5_1_1_1 = new JButton("Fjern medarbejder");
		btnNewButton_1_5_1_1_1.setBounds(10, 113, 173, 23);
		layeredPane_1.add(btnNewButton_1_5_1_1_1);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Kunde", null, layeredPane_2, null);
		
		JButton btnUdlnMaskine_1_1 = new JButton("Opret kunde ");
		btnUdlnMaskine_1_1.setBounds(10, 11, 173, 23);
		layeredPane_2.add(btnUdlnMaskine_1_1);
		
		JButton btnNewButton_1_3_1_1 = new JButton("Gennemse kunde");
		btnNewButton_1_3_1_1.setBounds(10, 45, 173, 23);
		layeredPane_2.add(btnNewButton_1_3_1_1);
		
		JButton btnNewButton_1_5_1_2_1 = new JButton("Tilføj ny kunde");
		btnNewButton_1_5_1_2_1.setBounds(10, 79, 173, 23);
		layeredPane_2.add(btnNewButton_1_5_1_2_1);
		
		JButton btnNewButton_1_5_1_1_1_1 = new JButton("Fjern kunde");
		btnNewButton_1_5_1_1_1_1.setBounds(10, 113, 173, 23);
		layeredPane_2.add(btnNewButton_1_5_1_1_1_1);
		
		JButton btnNewButton_1_5_1_1_1_1_1 = new JButton("Angiv kunde kategori");
		btnNewButton_1_5_1_1_1_1_1.setBounds(10, 147, 173, 23);
		layeredPane_2.add(btnNewButton_1_5_1_1_1_1_1);
		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		tabbedPane.addTab("Lager", null, layeredPane_4, null);
		
		JButton btnNewButton_1_5_1_1_1_1_2 = new JButton("Find vare");
		btnNewButton_1_5_1_1_1_1_2.setBounds(10, 11, 173, 23);
		layeredPane_4.add(btnNewButton_1_5_1_1_1_1_2);
		
		JButton btnNewButton_1_5_1_1_1_1_3 = new JButton("Bestil vare ");
		btnNewButton_1_5_1_1_1_1_3.setBounds(10, 45, 173, 23);
		layeredPane_4.add(btnNewButton_1_5_1_1_1_1_3);
		
		JButton btnNewButton_1_5_1_1_1_1_4 = new JButton("Lager optælling ");
		btnNewButton_1_5_1_1_1_1_4.setBounds(10, 79, 173, 23);
		layeredPane_4.add(btnNewButton_1_5_1_1_1_1_4);
		
		JLayeredPane layeredPane_5 = new JLayeredPane();
		tabbedPane.addTab("Statistik", null, layeredPane_5, null);
		
		JButton btnNewButton_1_5_1_1_1_1_5 = new JButton("Medarbejder statestik");
		btnNewButton_1_5_1_1_1_1_5.setBounds(10, 11, 173, 23);
		layeredPane_5.add(btnNewButton_1_5_1_1_1_1_5);
		
		JButton btnNewButton_1_5_1_1_1_1_6 = new JButton("Kunde statestik");
		btnNewButton_1_5_1_1_1_1_6.setBounds(10, 45, 173, 23);
		layeredPane_5.add(btnNewButton_1_5_1_1_1_1_6);
		
		JButton btnNewButton_1_5_1_1_1_1_7 = new JButton("Lager statestik ");
		btnNewButton_1_5_1_1_1_1_7.setBounds(10, 79, 173, 23);
		layeredPane_5.add(btnNewButton_1_5_1_1_1_1_7);
		
		JButton btnNewButton_9 = new JButton("Logud");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logOut();
			}
		});
		btnNewButton_9.setBounds(339, 242, 89, 23);
		contentPane.add(btnNewButton_9);
		
	
	}

	protected void logOut() {
		Login login = new Login();
		login.setVisible(true);
        Menu.this.setVisible(false);
        Menu.this.dispose();
		
	}

}
