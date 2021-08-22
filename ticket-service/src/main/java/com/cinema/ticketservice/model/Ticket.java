package com.cinema.ticketservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private int id;

    @Positive
    private int sessionId;

    @Positive
    private int userId;

    @Positive
    @Column(name = "line")
    private int row;

    @Positive
    private int seat;
}
