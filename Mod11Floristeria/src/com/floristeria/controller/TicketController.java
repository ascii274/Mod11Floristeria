package com.floristeria.controller;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import com.floristeria.model.domain.Producte;
import com.floristeria.model.domain.Ticket;
import com.floristeria.model.persistance.TicketRepository;

public class TicketController {
	TicketRepository ticketRepository = new TicketRepository();
	Ticket ticket;
	ProductesController productesController;
	public TicketController() {

	}

	public void creaTicket() {
		ticket = new Ticket();
	}

	public void afegirProducte(Producte producte) throws Exception {
		try {
			ticket.addCompra(producte);
		} catch (Exception e) {
			System.out.println("Error al afegir el producte al ticket");
		}

	}

	// cridem Stock controller per visualitzar stock.
	public void mostrarProductes() {
		productesController = new ProductesController();
		productesController.mostraStockPerPantalla();
	}

	
	/**
	 * -Retorna les dades del ticket -Si ho faig amb un return de un for, surt tot
	 * en una linea. <----
	 */
	public String mostraContigutTicket() {
//		List<Producte> compres = ticket.getCompres();
		return ticket.toString();
		// compres.stream().forEach(v->System.out.println(v));
//		productes.stream().forEach(System.out::println);		
	}


	/**
	 * -Mostra per pantalla el tickets anteriors.
	 */
	public String mostrarTicketsAnteriors() {
		List<Ticket> tickets = ticketRepository.getTickets();
		String resultado="";
		if (!tickets.isEmpty()) {
			for(Ticket t:tickets) {
				resultado += t.toString() + "\n";				
			}
			
//			tickets.stream().forEach(v -> System.out.println(v));
		} else {
			System.out.println("No n'hi ha compres anteriors.");
		}
		return resultado;
	}

	/**
	 * -Mostra per pantalla la suma total de tots el tickets fetes anteriorment.
	 */
	public double mostraDinersGuanyatAmbVentes() {
		List<Ticket> tickets = ticketRepository.getTickets();
		return tickets.stream().mapToDouble(Ticket::mostraTotalTicket).sum();
	}
	
	//******************** inici borrar al aplicar metode grafic *******************
	// pregunta a l'usuari les compres que vol fer afegint productes al ticket
		/**
		 * - Per esborrar en aplicar mode gràfic
		 * 
		 * @throws Exception
		 */
		public void seleccioniProducte() throws Exception {
			Scanner scanner = new Scanner(System.in);
			Producte producte;

			int codigoProducto = -1;
			do {

				System.out.println("\nSeleccioni codigo producte:");
				codigoProducto = scanner.nextInt();
				scanner.nextLine(); // para no saltar de linea
				if (codigoProducto != 0) {
					producte = productesController.buscaProductePerIdProducte(codigoProducto);
					if (!Objects.isNull(producte)) {
						ticket.addCompra(producte);
					}
				}
			} while (codigoProducto != 0); // salir
			ticketRepository.addTicket(ticket);
			System.out.println("\nTicket creat, número:[" + ticket.getNumTicket() + "], fecha:" + ticket.getFecha());
			// scanner.close();
		}
		
		//******************** fi borrar al aplicar metode grafic *******************


}
