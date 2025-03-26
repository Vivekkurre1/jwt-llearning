package com.jwt.example.config;

import com.jwt.example.security.JWTAuthenticationEntryPoint;
import com.jwt.example.security.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private JWTAuthenticationEntryPoint entryPoint;

    @Autowired
    private JWTAuthenticationFilter authFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //Configuration

        http.csrf(
                csrf ->
                        csrf.disable()).cors(
                                cors ->
                                        cors.disable()).authorizeHttpRequests(
                                                auth ->
                                                        auth.requestMatchers("/home/**").authenticated()
                                                       .requestMatchers("/auth/login").permitAll()
                                                       .anyRequest().authenticated())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(entryPoint))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        ;

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
