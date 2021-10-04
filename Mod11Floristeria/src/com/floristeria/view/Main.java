package com.floristeria.view;

import java.util.List;
import java.util.Scanner;

import javax.management.Query;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalTabbedPaneUI;

import com.floristeria.controller.ProductesController;
import com.floristeria.controller.TicketController;
import com.floristeria.model.domain.Arbre;
import com.floristeria.model.domain.Decoracion;
import com.floristeria.model.domain.Floristeria;
import com.floristeria.model.domain.Producte;
import com.floristeria.model.domain.Ticket;
import com.floristeria.model.domain.TipusMaterial;
import com.floristeria.model.persistance.ProductesRepository;

public class Main {
	private static ProductesController productesController = new ProductesController();
	private static TicketController ticketController = new TicketController();

	public static void main(String[] args) {
		
		Floristeria floristeria;
		try {
			// alta floristeria			
			floristeria = new Floristeria("Floristeria Java");
			// alta floristeria per InputDialog
			floristeria = crearFloristeria("Floristeria Java");
			System.out.println(floristeria.toString());
			

			// [CFV] Nova versió que crida a la Vista MAin per fer la part visual
			// Creem la pantalla o Frame principal
			JFrame marco = new ViewMain(floristeria, productesController);
			marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			marco.setVisible(true);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	private static Floristeria crearFloristeria(String nomFloristeriaIn) {
		String message = "Introdueix el nom de la Floristeria: " + "\n";
		String nomFloristeria;

		nomFloristeria = JOptionPane.showInputDialog(null, message, nomFloristeriaIn);

		return new Floristeria(nomFloristeria);
		
	}
	
	
}
