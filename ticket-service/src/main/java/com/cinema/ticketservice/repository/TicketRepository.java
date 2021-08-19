package com.cinema.ticketservice.repository;

import com.cinema.ticketservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Ticket t set t.sessionId = ?1, t.userId = ?2, t.row = ?3, t.seat = ?4 where t.id = ?5")
    void updateTicket(int sessionId, int userId, int row, int seat, int id);
}
