package com.cinema.ticketservice.controller;

import com.cinema.ticketservice.model.Ticket;
import com.cinema.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    Ticket createTicket(@Valid @RequestBody Ticket ticket){
        return ticketService.createTicket(ticket);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    Ticket getTicket(@PathVariable int id){
        return ticketService.getTicket(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Ticket updateTicket(@PathVariable int id, @Valid @RequestBody Ticket ticket){
        return ticketService.updateTicket(id, ticket);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTicket(@PathVariable int id){
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
