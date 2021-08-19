package com.cinema.sessionservice.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDTO {
    @Positive
    private int filmId;
    @Positive
    private double filmTime;
    @Positive
    private int seats;
    @NotNull
    private LocalDateTime startTime;
}
