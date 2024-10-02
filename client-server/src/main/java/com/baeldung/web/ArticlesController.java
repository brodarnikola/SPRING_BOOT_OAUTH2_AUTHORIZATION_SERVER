package com.baeldung.web;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@RestController
public class ArticlesController {

    public ArticlesController(WebClient webClient) {
        this.webClient = webClient;
    }

    private WebClient webClient;

//    Finally, we can create the data access controller.
//    We’ll use the previously configured WebClient to send an HTTP request to our resource server:

//    In the above example, we’re taking the OAuth authorization token from the request in a form of OAuth2AuthorizedClient class.
//    It’s automatically bound by Spring using the @RegisterdOAuth2AuthorizedClient annotation with proper identification.
//    In our case, it’s pulled from the article-client-authorizaiton-code that we configured previously in the .yml file.
//
//    This authorization token is further passed to the HTTP request.

    @GetMapping(value = "/articles")
    public String[] getArticles(
      @RegisteredOAuth2AuthorizedClient("articles-client-authorization-code") OAuth2AuthorizedClient authorizedClient
    ) {
        return this.webClient
          .get()
          .uri("http://127.0.0.1:8090/articles")
          .attributes(oauth2AuthorizedClient(authorizedClient))
          .retrieve()
          .bodyToMono(String[].class)
          .block();
    }
}