package com.example.IT_Security_Keycloak;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthConverter AuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/admin/**").hasRole("admin")
                .requestMatchers("/manager/**").hasAnyRole("admin", "manager")
                .requestMatchers("/developer/**").hasAnyRole("admin", "manager", "developer")
                .requestMatchers("/user/**").hasAnyRole("admin", "manager", "developer", "user")
                .requestMatchers("/developerOnly/**").hasAnyRole("admin", "developer")
                .requestMatchers("/userOnly/**").hasAnyRole("admin", "user")
                .anyRequest().authenticated());
        http
            .oauth2ResourceServer((oauth2) -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(AuthConverter)));

        return http.build();
    }

}
