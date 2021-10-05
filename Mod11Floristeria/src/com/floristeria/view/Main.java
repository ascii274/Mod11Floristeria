package com.floristeria.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.floristeria.controller.ProductesController;
import com.floristeria.controller.TicketController;
import com.floristeria.model.domain.Floristeria;
import com.floristeria.model.domain.TipusMaterial;

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
			
			
			PrecargaStock(productesController);

			// [CFV] Nova versió que crida a la Vista MAin per fer la part visual
			// Creem la pantalla o Frame principal
			JFrame marco = new ViewMain(floristeria, productesController, ticketController);
			marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			marco.setVisible(true);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	private static void PrecargaStock(ProductesController productesController) {
		try {
			productesController.creaArbre(34, 100, 1);
			productesController.creaFlor(20, "Negre", 2);
			productesController.creaDecoracio(16, TipusMaterial.FUSTA, 3);
			productesController.creaArbre(44, 120, 4);
			productesController.creaFlor(18, "Blanca", 5);
			productesController.creaDecoracio(26, TipusMaterial.PLASTIC, 6);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
