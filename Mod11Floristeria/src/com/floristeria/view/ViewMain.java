package com.floristeria.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.floristeria.controller.ProductesController;
import com.floristeria.controller.TicketController;
import com.floristeria.model.domain.Floristeria;

public class ViewMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int PosXWindow = 10;
	static int PosYWindow = 10;
	static int WinthWindow = 1000; // ample
	static int HeightWindow = 600; // alt

	private ViewBotons viewBotons;
	private ViewInfo viewInfo;

	public ViewMain(Floristeria floristeria, ProductesController productesController,
			TicketController ticketController) {

		// ********* Disseny del Frame **************
		this.setBounds(100, 100, 1320, 600);
		// posa el frame al centre de la pantalla
		this.setLocationRelativeTo(null);
		setTitle("Gestió Floristeria" + floristeria);

		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(null);
		setVisible(true);

//		// Pintem el Panell de Dades
		viewInfo = new ViewInfo(floristeria, productesController);
		this.getContentPane().add(BorderLayout.CENTER, viewInfo);

		// Pintem el Panell de botons
		viewBotons = new ViewBotons(floristeria, productesController, ticketController, viewInfo);
		this.getContentPane().add(BorderLayout.SOUTH, viewBotons);

		// ************** Disseny Label i TextFields ************

	}

}
