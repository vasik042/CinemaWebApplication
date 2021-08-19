package com.cinema.userservice.model;

import com.cinema.userservice.DTO.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String password;

    public UserDTO toDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setId(id);

        return userDTO;
    }
}
