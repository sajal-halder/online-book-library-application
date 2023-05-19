package com.sajal.onlinebooklibraryapplication;

import com.sajal.onlinebooklibraryapplication.entity.RoleEnum;
import com.sajal.onlinebooklibraryapplication.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OnlineBookLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookLibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleService roleService, PasswordEncoder encoder) {
		return args -> {
			roleService.addRole(RoleEnum.ADMIN);
			roleService.addRole(RoleEnum.CUSTOMER);
		};
	}

}
