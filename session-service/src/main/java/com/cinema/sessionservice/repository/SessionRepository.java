package com.cinema.sessionservice.repository;

import com.cinema.sessionservice.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Session s set s.filmId = ?1, s.startTime = ?2, s.endTime = ?3 where s.id = ?4")
    void updateSession(int filmId, LocalDateTime startTime, LocalDateTime endTime, int id);
}
