package com.cinema.userservice.service;

import com.cinema.userservice.DTO.UserDTO;
import com.cinema.userservice.model.User;
import com.cinema.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO){
        if(!userDTO.getPassword().equals(userDTO.getRepeatPassword())){
            throw new RuntimeException();
        }

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user).toDTO();
    }

    public UserDTO getUser(int id){
        return userRepository.getById(id).toDTO();
    }
}
