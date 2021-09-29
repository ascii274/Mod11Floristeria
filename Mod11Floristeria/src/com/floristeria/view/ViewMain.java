package com.floristeria.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.floristeria.model.domain.Floristeria;

public class ViewMain extends JFrame {

	static int PosXWindow = 10;
	static int PosYWindow = 10;
	static int WinthWindow = 1000; // ample
	static int HeightWindow = 600; // alt

	private JButton floristeria = new JButton("Floristeria");
	private ViewBotons viewBotons;
	private ViewDades viewDades;

	public ViewMain(Floristeria floristeria) {

		// ********* Disseny del Frame **************
		this.setBounds(100, 100, 1000, 600);
		setTitle("Gestió Floristeria" + floristeria);

		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setLayout(null);
		setVisible(true);

		// Pintem el Panell de Dades
		viewDades = new ViewDades();
		this.getContentPane().add(BorderLayout.CENTER, viewDades);

		// Pintem el Panell de botons
		viewBotons = new ViewBotons();
		this.getContentPane().add(BorderLayout.SOUTH, viewBotons);

		// ************** Disseny Label i TextFields ************

	}

}
