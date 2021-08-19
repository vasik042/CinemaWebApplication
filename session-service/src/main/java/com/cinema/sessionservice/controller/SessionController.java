package com.cinema.sessionservice.controller;

import com.cinema.sessionservice.DTO.SessionDTO;
import com.cinema.sessionservice.model.Session;
import com.cinema.sessionservice.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    Session createSession(@Valid @RequestBody SessionDTO sessionDTO){
        return sessionService.createSession(sessionDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    Session getSession(@PathVariable int id){
        return sessionService.getSession(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Session updateSession(@PathVariable int id, @Valid @RequestBody SessionDTO sessionDTO){
        return sessionService.updateSession(id, sessionDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteSession(@PathVariable int id){
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }
}
