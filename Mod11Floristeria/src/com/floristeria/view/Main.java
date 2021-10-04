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
	
//	public static void crearTicket() throws Exception {
//		// ticket
//		System.out.println("****** Creant Ticket ******");		
//		ticketController.creaTicket();// constructor
//		ticketController.mostrarProductes();// mostra tots el productes
//		ticketController.seleccioniProducte(); // 
//		System.out.println("******  La seva compra *****");
//		System.out.println(ticketController.mostraContigutTicket());		
//	}
	
	
	/**
	 * - Opc 1: crea ticket 
	 * - Opc 2: veuere tickets antigues
	 * @param opc
	 */
//	public static void selectOpcionCreaTickeVeureTicket(int opc) {
//		switch (opc) {
//		case 1:
//			try {
//				crearTicket();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		case 2:
//			ticketController.mostrarTicketsAnteriors();
//			break;
//		case 3:
//			System.out.println("Total diners guanyats: " + ticketController.mostraDinersGuanyatAmbVentes());
//			break;
//
//		default:
//			System.out.println("Només opcions del  1 al 2");
//			break;
//		}
//	}

}
