package com.cinema.filmsservice.repository;

import com.cinema.filmsservice.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Film f set f.name = ?1, f.description = ?2, f.time = ?3 where f.id = ?4")
    void updateFilm(String name, String description, double time, int id);
}
