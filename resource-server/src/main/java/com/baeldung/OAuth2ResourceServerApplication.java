package com.baeldung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Now we’ll create a resource server that will return a list of articles from a GET endpoint.
// The endpoints should allow only requests that are authenticated against our OAuth server.
@SpringBootApplication
public class OAuth2ResourceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ResourceServerApplication.class, args);
    }

}