package com.cinema.userservice.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserDTO {
    private int id;

    @Email(message = "Email should ve valid")
    @NotBlank(message = "Email should not be empty")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "Password should contains at least 8 characters, one uppercase letter and one number")
    @NotBlank(message = "Password should not be empty")
    private String password;

    @NotBlank(message = "Repeat password should not be empty")
    private String repeatPassword;
}
