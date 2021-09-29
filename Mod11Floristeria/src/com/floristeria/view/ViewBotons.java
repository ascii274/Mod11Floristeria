package com.floristeria.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.text.View;

import com.floristeria.controller.ProductesController;
import com.floristeria.model.domain.Floristeria;

public class ViewBotons extends JPanel {

	// Creem els botons per interactuar amb el Coet
	JButton addArbre = new JButton("Afegir Arbre");
	JButton addFlor = new JButton("Afegir Flor");
	JButton addDecoracio = new JButton("Afegir Arbre");
	JButton printStock = new JButton("Imprimir Stock");
	
	Floristeria floristeria;

	public ViewBotons(Floristeria floristeria) {
		this.floristeria=floristeria;
		
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
				addArbre.setEnabled(false);
				addFlor.setEnabled(true);
				addDecoracio.setEnabled(true);
				printStock.setEnabled(true);
				accionBotones(e);
			}
		});
		addArbre.setBounds(100, 40, 100, 40);

		// Pintem el botó accelerar
		addFlor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addArbre.setEnabled(false);
				addFlor.setEnabled(true);
				addDecoracio.setEnabled(true);
				accionBotones(e);
			}
		});
		addFlor.setBounds(210, 40, 100, 40);

		// Pintem el botó frenar
		addDecoracio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addArbre.setEnabled(false);
				addFlor.setEnabled(true);
				addDecoracio.setEnabled(true);

				accionBotones(e);
			}
		});
		addDecoracio.setBounds(320, 40, 100, 40);

		// Pintem el botó de parar el coet
		printStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addArbre.setEnabled(true);
				addFlor.setEnabled(false);
				addDecoracio.setEnabled(false);

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
			ViewArbre vArbre = new ViewArbre();
			System.out.println("Arbre afegit" + floristeria);
			
		}

		if (e.getSource() == addFlor) {
			System.out.println("Afegeix un addFlor");
		}

		if (e.getSource() == addDecoracio) {
			System.out.println("Afegeix un addDecoracio");
		}

		if (e.getSource() == printStock) {
			System.out.println("Afegeix un printStock");
		}

	}

}
