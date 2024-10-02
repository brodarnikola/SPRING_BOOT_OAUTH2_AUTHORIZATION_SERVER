package com.baeldung.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class SecurityConfig {

//    Here, as well as in other servers, we’ll need every request to be authenticated.
//    Additionally, we need to configure the login page URL (defined in .yml config) and the OAuth client.

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
          .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests.anyRequest().authenticated()
          )
          .oauth2Login(oauth2Login ->
            oauth2Login.loginPage("/oauth2/authorization/articles-client-oidc"))
          .oauth2Client(withDefaults());
        return http.build();
    }
}