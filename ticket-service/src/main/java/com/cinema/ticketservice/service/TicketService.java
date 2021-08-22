package com.cinema.ticketservice.service;

import com.cinema.ticketservice.model.Ticket;
import com.cinema.ticketservice.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket getTicket(int id){
        return ticketRepository.findById(id).get();
    }

    public Ticket updateTicket(int id, Ticket ticket){
        ticketRepository.updateTicket(ticket.getSessionId(),
                ticket.getUserId(),
                ticket.getRow(),
                ticket.getSeat(),
                id);

        return getTicket(id);
    }

    public void deleteTicket(int id){
        ticketRepository.deleteById(id);
    }
}
