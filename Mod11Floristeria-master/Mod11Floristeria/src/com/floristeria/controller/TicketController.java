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
	
	public String mostrarProductes() {
		productesController = new ProductesController();
		return productesController.mostraStockPerPantalla();
	}
	
	/**
	 * -Retorna les dades del ticket 
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
	
	
	public void afegirTicket(Ticket ticket) {
		try {
			ticketRepository.addTicket(ticket);
		} catch (Exception e) {
			System.out.println("Errro al agregar el ticket:" + e.getMessage());
		}		
	}

	public Ticket getTicket() {
		return ticket;
	}
	
	

}
