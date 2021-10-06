package com.floristeria.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.floristeria.controller.ProductesController;
import com.floristeria.model.domain.Floristeria;

public class ViewInfo extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Floristeria floristeria;
	ProductesController productesController;
	Utilities u;
	private JLabel infoFromBotons;
	private JLabel infoFromBotonsError;

	private JTextArea infoProducte;
	private JTextArea infoTicket;

	public ViewInfo(Floristeria floristeria, ProductesController productesController) {
		this.floristeria = floristeria;
		this.productesController = productesController;

		this.u = new Utilities();

		Font miFuente = new Font("Arial", Font.BOLD, 16);
		this.setLayout(null);

		// Creem la label/columna del noms de propulsors
		JLabel nomFloristeria = new JLabel("" + floristeria.toString(), SwingConstants.CENTER);
		nomFloristeria.setFont(miFuente);
		nomFloristeria.setForeground(Color.BLACK);
		nomFloristeria.setBounds(20, 10, 1150, 50);
		this.add(nomFloristeria);

		// Creem un label per simular el System.out.println() explican que hem fet
		infoFromBotons = new JLabel("Text From botons curt", SwingConstants.LEFT);
		infoFromBotons.setFont(miFuente);
		infoFromBotons.setForeground(Color.BLUE);
		infoFromBotons.setBounds(20, 40, 1150, 50);
		this.add(infoFromBotons);

		// Creem un camp Texte Multilinia per imprimir el Stock
		infoProducte = new JTextArea("Impresio Stocks", 10, 0);
		infoProducte.setFont(miFuente);
		infoProducte.setForeground(Color.BLACK);
		infoProducte.setBounds(20, 100, 550, 340);
		this.add(infoProducte);

		// Creem un camp Texte Multilinia per imprimir els Tickets
		infoTicket = new JTextArea("Impresio Tickets", 10, 0);
		infoTicket.setFont(miFuente);
		infoTicket.setForeground(Color.BLACK);
		infoTicket.setBounds(550+40, 100, 550, 340);
		this.add(infoTicket);
		
		// Creem un lable per mostrar els erors
		infoFromBotonsError = new JLabel("Text error", SwingConstants.CENTER);
		infoFromBotonsError.setFont(miFuente);
		infoFromBotonsError.setForeground(Color.RED);
		infoFromBotonsError.setBounds(20, 450, 1150, 50);
		this.add(infoFromBotonsError);

		// fem visible el marc
		setVisible(true);

	}

	// Bloc de métodes per el text curt que informarem desde view botons
	public JLabel getLabel() {
		return infoFromBotons;
	}

	public void setLabel(JLabel label) {
		this.infoFromBotons = label;
	}

	public void setTextLabel(String text) {
		infoFromBotons.setText(text);
	}

	// Bloc de métodes per el text gran que informarem desde view botons
	public JLabel getLabelError() {
		return infoFromBotonsError;
	}

	public void setLabelError(JLabel label) {
		this.infoFromBotonsError = label;
	}

	public void setTextLabelError(String text) {
		infoFromBotonsError.setText(text);
	}

	// Bloc de métodes per el text gran que informarem desde view botons referent al Stock
	public JTextArea getinfo() {
		return infoProducte;
	}

	public void setTextGran(JTextArea text) {
		this.infoProducte = text;
	}

	public void setTextInfoProducte(String text) {
		infoProducte.setText(text);
	}

	
	// Bloc de métodes per el text gran que informarem desde view botons referent al Ticket
	public JTextArea getinfoTicket() {
		return infoTicket;
	}

	public void setTextGranTicket(JTextArea text) {
		this.infoTicket = text;
	}

	public void setTextInfoTicket(String text) {
		infoTicket.setText(text);
	}
}
