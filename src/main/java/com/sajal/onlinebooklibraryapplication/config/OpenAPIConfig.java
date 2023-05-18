package com.sajal.onlinebooklibraryapplication.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.web.bind.annotation.RestController;

@RestController
@OpenAPIDefinition(info =
@Info(
        title = "Online Book Library Application",
        version = "1.0",
        description = "Documentation for Online Book Library Application",

        contact = @Contact( name = "Sajal halder", email = "sajal.halder@bjitcademy.com")
)
)
public class OpenAPIConfig {
}
