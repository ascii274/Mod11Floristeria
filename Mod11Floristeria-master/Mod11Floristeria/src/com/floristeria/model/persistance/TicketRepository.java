package com.floristeria.model.persistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.floristeria.model.domain.Ticket;

public class TicketRepository {
	private List<Ticket> tickets = new ArrayList<>();
	
	public TicketRepository() {
	
	}
	
	public List<Ticket> getTickets(){
		//return tickets;
		return new ArrayList<>(tickets);
	}
	
	public void addTicket(Ticket ticket) throws Exception{
		if(Objects.isNull(ticket)) throw new Exception();
		tickets.add(ticket);
	}
}
