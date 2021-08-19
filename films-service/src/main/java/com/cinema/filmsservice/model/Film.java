package com.cinema.filmsservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Film {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Positive
    private double time; //hours
}
