package com.sajal.onlinebooklibraryapplication.config;

import com.sajal.onlinebooklibraryapplication.entity.RoleEnum;
import com.sajal.onlinebooklibraryapplication.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/**","/api-docs/**")
                .permitAll()
                .requestMatchers("/books/create","/books/update/**","/books/delete/**")
                .hasAuthority(RoleEnum.ADMIN.name())
                .requestMatchers("/books/all","/books/id/**","/books/author-title/**","/books/author/**")
                .hasAnyAuthority(RoleEnum.ADMIN.name(),RoleEnum.CUSTOMER.name())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();

    }
}
