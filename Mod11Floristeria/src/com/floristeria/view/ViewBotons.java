package com.floristeria.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import com.floristeria.controller.ProductesController;
import com.floristeria.model.domain.Floristeria;
import com.floristeria.model.domain.Producte;
import com.floristeria.model.domain.TipusMaterial;

public class ViewBotons extends JPanel {

	// Creem els botons per interactuar amb el Coet
	JButton addArbre = new JButton("Afegir Arbre");
	JButton addFlor = new JButton("Afegir Flor");
	JButton addDecoracio = new JButton("Afegir Decoració");
	JButton printStock = new JButton("Imprimir Stock");

	// ***** Botons Nivell 2 *****
	JButton removeArbre = new JButton("Retirar Arbre");
	JButton removeFlor = new JButton("Retirar Flor");
	JButton removeDecoració = new JButton("Retirar Decoració");
	JButton printStockQuantitats = new JButton("Imprimir Stock amb quantitats");
	JButton printSumTotal = new JButton("Imprimir valor total Floristeria");

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

		// ***** Botons Nivell 2 *****
		removeArbre.setEnabled(true);
		removeFlor.setEnabled(true);
		removeDecoració.setEnabled(true);
		printStockQuantitats.setEnabled(true);
		printSumTotal.setEnabled(true);

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

		// ***** Botons Nivell 2 *****
		// Pintem el botó retirar un arbre
		removeArbre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accionBotones(e);
			}
		});
		removeArbre.setBounds(430, 40, 100, 40);

		// Pintem el botó de retirar una Flor
		removeFlor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accionBotones(e);
			}
		});
		removeFlor.setBounds(430, 40, 100, 40);

		// Pintem el botó de retirar una decoració
		removeDecoració.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accionBotones(e);
			}
		});
		removeDecoració.setBounds(430, 40, 100, 40);

		// Pintem el botó de pintar el Stocks amb quantitats
		printStockQuantitats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accionBotones(e);
			}
		});
		printStockQuantitats.setBounds(430, 40, 100, 40);

		// Pintem el botó de pintar el valor totas de la floristaria
		printSumTotal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accionBotones(e);
			}
		});
		printSumTotal.setBounds(430, 40, 100, 40);

		/*******************************************************************************/

		add(addArbre);
		add(addFlor);
		add(addDecoracio);
		add(printStock);

		// ***** Botons Nivell 2 *****
		add(removeArbre);
		add(removeFlor);
		add(removeDecoració);
		add(printStockQuantitats);
		add(printSumTotal);

		setVisible(true);
	}

	protected void accionBotones(ActionEvent e) {

		if (e.getSource() == addArbre) {
			System.out.println("Afegeix un arbre");

			try {
				// per si un cas netegem el text error
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
				// per si un cas netegem el text error
				viewInfo.setTextLabelError("");

				double preu = this.getPreu("Flor");
				String color = this.getColor();
				int stock = this.getStock();
				this.productesController.creaFlor(preu, color, stock);

				System.out.println("Afegeix un addFlor");
				viewInfo.setTextLabel("Flor afegida " + floristeria);

				viewInfo.setTextInfoProducte(this.productesController.obtenirStock_toString());
			} catch (Exception e1) {
				viewInfo.setTextLabelError("Error " + e1.getMessage());
			}

		}

		if (e.getSource() == addDecoracio) {

			try {
				// per si un cas netegem el text error
				viewInfo.setTextLabelError("");

				double preu = this.getPreu("Decoració");
				TipusMaterial tipusMaterial = this.getTipusMaterial();
				int stock = this.getStock();
				this.productesController.creaDecoracio(preu, tipusMaterial, stock);

				System.out.println("Afegeix un addDecoracio");
				viewInfo.setTextLabel("Decoració afegida " + floristeria);
				viewInfo.setTextInfoProducte(this.productesController.obtenirStock_toString());
			} catch (Exception e1) {
				viewInfo.setTextLabelError("Error " + e1.getMessage());
			}

		}

		if (e.getSource() == printStock) {
			try {
				// per si un cas netegem el text error
				viewInfo.setTextLabelError("");

				String s = this.productesController.mostraStockPerPantalla();

				System.out.println("Impresió Stock");
				viewInfo.setTextLabel("Impresió Stock " + floristeria);
				viewInfo.setTextInfoProducte(s);
			} catch (Exception e1) {
				viewInfo.setTextLabelError("Error " + e1.getMessage());
			}
		}

		// ***** Botons Nivell 2 *****
		if (e.getSource() == removeArbre || e.getSource() == removeFlor || e.getSource() == removeDecoració) {
			try {
				// per si un cas netegem el text error
				viewInfo.setTextLabelError("");

				String tipusProducte = "";
				if (e.getSource() == removeArbre)
					tipusProducte = "Arbre";
				else if (e.getSource() == removeFlor)
					tipusProducte = "Flor";
				else
					tipusProducte = "Decoració";

				
				int id = this.getIdProducte(tipusProducte);
				Producte p = this.productesController.buscaProductePerIdProducte(id);

				// Confirmació de que vols eliminar el producte
				if (this.IsthisProducte(p.getIdProducte())) {
					this.productesController.borraProducte(p.getIdProducte());
					
					System.out.println("S'ha borrat del ID producte " + p.getIdProducte());
					viewInfo.setTextLabel("S'ha borrat del ID producte " + p.toString());
				} else {
					System.out.println("S'ha cancel.lat el borrat del ID producte " + p.getIdProducte());
					viewInfo.setTextLabel("S'ha cancel.lat el borrat del ID producte " + p.getIdProducte());
				}
				// Tant es faci com no es mostra el Stock per pantalla
				viewInfo.setTextInfoProducte(this.productesController.mostraStockPerPantalla());

			} catch (Exception e1) {
				viewInfo.setTextLabelError("Error " + e1.getMessage());
			}
		}

		// Pintem el Stock amb quantitats
		if (e.getSource() == printStockQuantitats) {
			try {
				// per si un cas netegem el text error
				viewInfo.setTextLabelError("");

				String s = this.productesController.mostraStocAmbQuantitats();

				System.out.println("Impresió Stock amb quantitats");
				viewInfo.setTextLabel("Impresió Stock amb quantitas" + floristeria);
				viewInfo.setTextInfoProducte(s);
			} catch (Exception e1) {
				viewInfo.setTextLabelError("Error " + e1.getMessage());
			}
		}

		// Printar per pantalla valor total de la floristeria
		if (e.getSource() == printSumTotal) {
			try {
				// per si un cas netegem el text error
				viewInfo.setTextLabelError("");

				double s = this.productesController.mostraValorTotalFloristeria();

				System.out.println("El valor total de la floristeria és = " + s);
				viewInfo.setTextLabel("El valor total de la floristeria és = " + s);
				viewInfo.setTextInfoProducte("El valor total de la floristeria és = " + s);
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
		String message = "Introdueix el preu del " + tipusProducte + ": " + "\n";
		boolean isOk = false;
		do {
			String preResultat = u.getUserInput(message);

			if (u.isNumeric(preResultat)) {
				resultat = Double.parseDouble(preResultat);
				isOk = true;
			} else {
				message = "Error. El valor introduit ha de ser numéric \n" + message;
			}
		} while (!isOk);
		return resultat;
	}

	private int getStock() {
		int resultat = 0;
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

	// Métode que li preguntará al usuari quin producte vol
	private int getIdProducte(String tipusProducte) {
		int resultat = 0;

		String message = "Introdueix el identificadr de producte  " + tipusProducte + ": " + "\n";
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

	// Métode que preguntará al usuari si Realment vol eliminar el producte
	private boolean IsthisProducte(int id) {
		String message = "¿Realment vols borrar el Producte amb la ID = " + id + "?";
		int confirmado = JOptionPane.showConfirmDialog(null, message);

		if (JOptionPane.OK_OPTION == confirmado)
			return true;
		else
			return false;
	}

}
