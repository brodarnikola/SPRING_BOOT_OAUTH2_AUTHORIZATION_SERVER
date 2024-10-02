package com.baeldung.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticlesController {

    // Now we’ll create a resource server that will return a list of articles from a GET endpoint.
    // The endpoints should allow only requests that are authenticated against our OAuth server.
    // Finally, we’ll create a REST controller that will return a list of articles under the GET /articles endpoint:
    @GetMapping("/articles")
    public String[] getArticles() {
        return new String[]{"Article 1", "Article 2", "Article 3"};
    }
}