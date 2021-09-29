package com.floristeria.view;

import java.awt.Font;

import javax.swing.JPanel;

import com.floristeria.controller.ProductesController;

public class ViewArbre extends JPanel {

	Utilities u = new Utilities();

	ProductesController producteControler;

	public ViewArbre() {
		setBounds(600, 0, 500, 500);

		Font miFuente = new Font("Arial", Font.BOLD, 20);

		// fem visible el marc
		setVisible(true);
		
		producteControler = new ProductesController();

		try {
			double preu = this.getPreu();
			int alzada = this.getAlzada();

			producteControler.creaArbre(preu, alzada);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public int getAlzada() {
		int resultat = 0;
		String message = "Introdueix l'Alçada del Arbre: " + "\n";
		boolean isOk = false;

		do {
			String preResultat = u.getUserInput(message);

			if (u.isNumeric(preResultat)) {
				resultat = Integer.parseInt(preResultat);
				isOk = true;
			} else {
				message = "Error. El valor introduit ha de ser numéric \n" + message;
			}

		} while (!isOk);

		return resultat;
	}

	private int getPreu() {
		int resultat = 0;
		String message = "Introdueix el preu del Arbre: " + "\n";
		boolean isOk = false;

		do {
			String preResultat = u.getUserInput(message);

			if (u.isNumeric(preResultat)) {
				resultat = Integer.parseInt(preResultat);
				isOk = true;
			} else {
				message = "Error. El valor introduit ha de ser numéric \n" + message;
			}

		} while (!isOk);

		return resultat;
	}
}
