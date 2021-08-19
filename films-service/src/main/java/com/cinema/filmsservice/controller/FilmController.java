package com.cinema.filmsservice.controller;

import com.cinema.filmsservice.model.Film;
import com.cinema.filmsservice.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/films")
public class FilmController {
    FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    Film createFilm(@Valid @RequestBody Film film){
        return filmService.createFilm(film);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    Film getFilm(@PathVariable int id){
        return filmService.getFilm(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Film updateFilm(@PathVariable int id, @Valid @RequestBody Film film){
        return filmService.updateFilm(id, film);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteFilm(@PathVariable int id){
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
