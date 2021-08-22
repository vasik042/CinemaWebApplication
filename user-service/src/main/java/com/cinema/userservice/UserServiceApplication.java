package com.cinema.userservice;

import com.cinema.userservice.DTO.UserDTO;
import com.cinema.userservice.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(UserServiceApplication.class, args);

		UserService userService = (UserService) run.getBean("userService");

		UserDTO userDTO = new UserDTO();
		userDTO.setEmail("email1@gmail.com");
		userDTO.setPassword("111aaaAAA");
		userDTO.setRepeatPassword("111aaaAAA");
		userService.createUser(userDTO);

		userDTO.setEmail("email2@gmail.com");
		userService.createUser(userDTO);

		userDTO.setEmail("email3@gmail.com");
		userService.createUser(userDTO);
	}

}
