package com.floristeria.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Ticket {
	private int numTicket =0;
	private static int numTicketSiguiente = 1;
	private LocalDateTime fecha; 
	private List<Producte> compres;
	private int totalCompra;
	
	public Ticket() {
		numTicket=numTicketSiguiente;
		numTicketSiguiente++;
		fecha=LocalDateTime.now();
		compres = new ArrayList<>();	
		totalCompra = 0;
	}
	
	/**
	 * - Afegeix el producte al List<Producte> compres
	 * @param producte
	 * @throws Exception
	 */
	public void addCompra(Producte producte) throws Exception{		
			if(Objects.isNull(1)) throw new Exception();
			compres.add(producte);		
	}
	
	public String  mostraContingutListCompres() {
		//return compres.toString();// lo muestra en una linea		
//		compres.stream().forEach(v->System.out.println(v)); //void
		
		String detalleCompra="";
		for(Producte p:compres) {
			detalleCompra += p.toString() + "\n\t";			
		}
		return detalleCompra;
	}
	
	
	public String toString() {		
		return "Ticket[Numero ticket:" + numTicket +  " ,Fecha:" + fecha + "]\n" 
				+ "\t" + mostraContingutListCompres() + "\n"
				+ "\n Total:" + mostraTotalTicket() + " euros\n";
		
	}
	
	/**
	 * - Suma el contigut de compres i ho retorna
	 * @return
	 */
	public double mostraTotalTicket() {
		return compres.stream().mapToDouble(Producte :: getPreu )  .sum();
	}
	
	
	// getters setters
	public List<Producte> getCompres() {
		return compres;
	}

	public int getNumTicket() {
		return numTicket;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public int getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(int totalCompra) {
		this.totalCompra = totalCompra;
	}
	
	
	
	
	
}

 