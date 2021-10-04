package com.floristeria.model.view;

import java.util.List;
import java.util.Scanner;

import javax.management.Query;
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
			
			// alta arbre
			productesController.creaArbre(10.00, 10,1);
			productesController.creaArbre(20.00, 20,2);
			productesController.creaArbre(30.00, 30,4);
			
//			// alta flor
			productesController.creaFlor(3.60, "Rosa",33);
			productesController.creaFlor(1.50, "Blanc",11);
			productesController.creaFlor(2.00, "Groc",532);
			
			// alta decoracio
			
//			productesController.creaDecoracio(36.30, TipusMaterial.FUSTA,58);
//			productesController.creaDecoracio(3.80, TipusMaterial.PLASTIC,66);
//			productesController.creaDecoracio(12.39, TipusMaterial.PLASTIC,75);
			
			productesController.mostraStockPerPantalla();		
			
			//borrado		
//			ProductesRepository productesRepository = new ProductesRepository();
//			List<Producte> productes = productesRepository.getAllProductes();
			//Producte producte = productes.get(0);			
			//productesController.borraProducte(producte);
			
			
//			// mostrem dades 
//			productesController.filtrarProductos(decoracion);
//			System.out.println(floristeria.toString());
			//productesController.obtenirStock();
			
			System.out.println("\n***** Stock *****");
			//System.out.println("Stock de productes:" + productesController.mostrarValorTotalFloristeria());
			System.out.println("La suma total de tots el productes:" + productesController.mostraValorTotalFlristeria() + " unidades");
			
			// tickets
			
			Scanner scanner = new Scanner(System.in);
			int opc=-1;			
			do {
				System.out.println("\nEscull una opció:\n 1:Crear Ticket / 2:Veure tickets anteriors / 3:Veure suma ventes");
				opc=scanner.nextInt();
				scanner.nextLine();				
				selectOpcionCreaTickeVeureTicket(opc);	
			} while (opc != 0);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void crearTicket() throws Exception {
		// ticket
		System.out.println("****** Creant Ticket ******");		
		ticketController.creaTicket();// constructor
		ticketController.mostrarProductes();// mostra tots el productes
		ticketController.seleccioniProducte(); // 
		System.out.println("******  La seva compra *****");
		System.out.println(ticketController.mostraContigutTicket());		
	}
	
	
	/**
	 * - Opc 1: crea ticket 
	 * - Opc 2: veuere tickets antigues
	 * @param opc
	 */
	public static void selectOpcionCreaTickeVeureTicket(int opc) {
		switch (opc) {
		case 1:
			try {
				crearTicket();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			ticketController.mostrarTicketsAnteriors();
			break;
		case 3:
			System.out.println("Total diners guanyats: " + ticketController.mostraDinersGuanyatAmbVentes());
			break;

		default:
			System.out.println("Només opcions del  1 al 2");
			break;
		}
	}

}
