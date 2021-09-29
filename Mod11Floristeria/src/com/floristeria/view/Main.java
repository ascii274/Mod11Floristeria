package com.floristeria.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.floristeria.model.domain.Floristeria;

public class Main {

	static Floristeria floristeria;

	public static void main(String[] args) {
		System.out.println("INICI PROGRAMA");

		try {

			crearFloristeria();

			// Creem la pantalla o Frame principal
			JFrame marco = new ViewMain(floristeria);
			marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			marco.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("FI DEL PROGRAMA");

	}

	public static void crearFloristeria() {
		int resultat = 0;
		String message = "Introdueix el nom de la Floristeria: " + "\n";
		String nomFloristeria;
		boolean isOk = false;
		Utilities u;

		nomFloristeria = JOptionPane.showInputDialog(null, message, "Flors Navarro");

		floristeria= new Floristeria(nomFloristeria);
	}
}
