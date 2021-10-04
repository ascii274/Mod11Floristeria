package com.floristeria.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.View;

import com.floristeria.controller.ProductesController;
import com.floristeria.model.domain.Floristeria;
import com.floristeria.model.domain.TipusMaterial;

public class ViewBotons extends JPanel {

	// Creem els botons per interactuar amb el Coet
	JButton addArbre = new JButton("Afegir Arbre");
	JButton addFlor = new JButton("Afegir Flor");
	JButton addDecoracio = new JButton("Afegir Decoració");
	JButton printStock = new JButton("Imprimir Stock");

	Floristeria floristeria;
	ProductesController productesController;
	ViewInfo viewInfo;
	Utilities u;

	public ViewBotons(Floristeria floristeria, ProductesController productesController, ViewInfo viewInfo) {
		this.floristeria = floristeria;
		this.productesController = productesController;
		this.viewInfo = viewInfo;

		this.u = new Utilities();

		// setLayout(null);
		addArbre.setEnabled(true);
		addFlor.setEnabled(true);
		addDecoracio.setEnabled(true);
		printStock.setEnabled(false);
		setBackground(Color.WHITE);
		Font miFuente = new Font("Arial", Font.BOLD, 16);

		// Pintem el botó d'arrancar
		addArbre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				addArbre.setEnabled(false);
//				addFlor.setEnabled(true);
//				addDecoracio.setEnabled(true);
				printStock.setEnabled(true);
				accionBotones(e);
			}
		});
		addArbre.setBounds(100, 40, 100, 40);

		// Pintem el botó accelerar
		addFlor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				printStock.setEnabled(true);
				accionBotones(e);
			}
		});
		addFlor.setBounds(210, 40, 100, 40);

		// Pintem el botó decoració
		addDecoracio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printStock.setEnabled(true);
				accionBotones(e);
			}
		});
		addDecoracio.setBounds(320, 40, 100, 40);

		// Pintem el botó de pintar el Stocks
		printStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accionBotones(e);
			}
		});
		printStock.setBounds(430, 40, 100, 40);

		/*******************************************************************************/

		// add(listMarchas);
		add(addArbre);
		add(addFlor);
		add(addDecoracio);
		add(printStock);

		setVisible(true);
	}

	protected void accionBotones(ActionEvent e) {

		if (e.getSource() == addArbre) {
			System.out.println("Afegeix un arbre");

			try {
				//per si un cas netegem el text error
				viewInfo.setTextLabelError("");
				
				
				double preu = this.getPreu("Arbre");
				int alzada = this.getAlzada();
				int stock = this.getStock();

				this.productesController.creaArbre(preu, alzada, stock);

				System.out.println("Arbre afegit " + floristeria);
				viewInfo.setTextLabel("Arbre afegit " + floristeria);

				viewInfo.setTextInfoProducte(this.productesController.obtenirStock_toString());
			} catch (Exception e1) {
				viewInfo.setTextLabelError("Error " + e1.getMessage());
			}

		}

		if (e.getSource() == addFlor) {

			try {
				//per si un cas netegem el text error
				viewInfo.setTextLabelError("");
				
				double preu = this.getPreu("Flor");
				String color = this.getColor();
				int stock = this.getStock();
				this.productesController.creaFlor(preu, color,stock);

				System.out.println("Afegeix un addFlor");
				viewInfo.setTextLabel("Flor afegida " + floristeria);
				
				
				viewInfo.setTextInfoProducte(this.productesController.obtenirStock_toString());
			} catch (Exception e1) {
				viewInfo.setTextLabelError("Error " + e1.getMessage());
			}

		}

		if (e.getSource() == addDecoracio) {

			try {
				//per si un cas netegem el text error
				viewInfo.setTextLabelError("");
				
				double preu = this.getPreu("Decoració");
				TipusMaterial tipusMaterial = this.getTipusMaterial();
				int stock = this.getStock();
				this.productesController.creaDecoracio(preu, tipusMaterial,stock);

				System.out.println("Afegeix un addDecoracio");
				viewInfo.setTextLabel("Decoració afegida " + floristeria);
				viewInfo.setTextInfoProducte(this.productesController.obtenirStock_toString());
			} catch (Exception e1) {
				viewInfo.setTextLabelError("Error " + e1.getMessage());
			}

		}

		if (e.getSource() == printStock) {
			try {
				//per si un cas netegem el text error
				viewInfo.setTextLabelError("");
				
				
				String s = this.productesController.obtenirStock_toString();

				System.out.println("Afegeix un addDecoracio");
				viewInfo.setTextLabel("Impresió Stock " + floristeria);
				viewInfo.setTextInfoProducte(s);
			} catch (Exception e1) {
				viewInfo.setTextLabelError("Error " + e1.getMessage());
			}
		}

	}

	/**
	 * Mètode per obtenir el tipus de material
	 * 
	 * @return
	 */
	private TipusMaterial getTipusMaterial() {
		int seleccio = JOptionPane.showOptionDialog(null, "Tipus Material", "Selector de opciones",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por defecto.
				new Object[] { TipusMaterial.FUSTA.toString(), TipusMaterial.PLASTIC.toString() }, // null para YES, NO
																									// y CANCEL
				TipusMaterial.FUSTA.toString());

		if (seleccio == 0)
			return TipusMaterial.FUSTA;
		else
			return TipusMaterial.PLASTIC;

	}

	/**
	 * Métode per obtenir el color de la flor
	 * 
	 * @return
	 */
	private String getColor() {
		String message = "Introdueix Color de la Flor : " + "\n";
		String resultat = "";
		boolean isOk = false;

		do {
			String preResultat = u.getUserInput(message);

			try {
				u.checkField("Color Flor", preResultat);
				isOk = true;
				resultat = preResultat;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				viewInfo.setTextLabelError(e.getMessage());
			}

		} while (!isOk);
		return resultat;
	}

	/**
	 * Funció per obtenir l'alçada del Arlbre
	 * 
	 * @return int Alçada Arbre
	 */
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

	/**
	 * Funció per obtenir el preu del Arbre
	 * 
	 * @return int Preu del Arbre
	 */
	private double getPreu(String tipusProducte) {
		double resultat = 0;
		String message = "Introdueix el preu del "+ tipusProducte + ": " + "\n";
		boolean isOk = false;
		do {
			String preResultat = u.getUserInput(message);

			if (u.isNumeric(preResultat)) {
				resultat =  Double.parseDouble(preResultat);
				isOk = true;
			} else {
				message = "Error. El valor introduit ha de ser numéric \n" + message;
			}
		} while (!isOk);
		return resultat;
	}

	private int getStock() {
		int resultat=0;
		String message = "Introdueix la quantitat d'estoc \n";
		
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
