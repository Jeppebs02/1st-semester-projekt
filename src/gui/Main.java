package gui;

import java.awt.EventQueue;

import tui.TryMe;

public class Main {

	public static void main(String[] args) {
		TryMe.addData();
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

	}


