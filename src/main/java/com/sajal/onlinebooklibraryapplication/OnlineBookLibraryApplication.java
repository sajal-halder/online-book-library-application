package com.sajal.onlinebooklibraryapplication;

import com.sajal.onlinebooklibraryapplication.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBookLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookLibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleService roleService) {
		return args -> {
			roleService.addRole("ADMIN");
			roleService.addRole("CUSTOMER");
		};
	}

}
