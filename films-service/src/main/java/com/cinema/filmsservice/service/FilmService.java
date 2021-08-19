package com.cinema.filmsservice.service;

import com.cinema.filmsservice.model.Film;
import com.cinema.filmsservice.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film getFilm(int id){
        return filmRepository.findById(id).get();
    }

    public Film createFilm(Film film){
        return filmRepository.save(film);
    }

    public Film updateFilm(int id, Film film){
        filmRepository.updateFilm(film.getName(),
                film.getDescription(),
                film.getTime(),
                id);
        return getFilm(id);
    }

    public void deleteFilm(int id){
        filmRepository.deleteById(id);
    }
}
