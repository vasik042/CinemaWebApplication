package com.cinema.sessionservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Session {
    @Id
    @GeneratedValue
    private int id;
    private int filmId;
    private int seats;
    private int freeSeats;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
