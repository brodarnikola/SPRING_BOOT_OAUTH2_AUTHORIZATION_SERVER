package com.baeldung.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

//    Now we can set up our web security configuration.
//    We want to explicitly state that every request to article resources should be authorized and have the proper articles.read authority:

//    As shown here, we’re also invoking the oauth2ResourceServer() method,
//    which will configure the OAuth server connection based on the application.yml configuration.

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher("/articles/**")
            .authorizeHttpRequests(authorize -> authorize.anyRequest()
                .hasAuthority("SCOPE_articles.read"))
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }
}