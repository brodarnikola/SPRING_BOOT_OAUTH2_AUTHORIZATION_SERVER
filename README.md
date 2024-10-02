## Spring Security OAuth Authorization Server

### Relevant information:

This module demonstrates OAuth authorization flow using Spring Authorization Server, Spring OAuth Resource Server and
Spring OAuth Client.

- Run the Authorization Server from the `spring-authorization-server` module
    - IMPORTANT: Modify the `/etc/hosts` file and add the entry `127.0.0.1 auth-server`
- Run the Resource Server from `resource-server` module
- Run the client from `client-server` module
- Go to `http://127.0.0.1:8080/articles`
    - Enter the credentials `admin/password`
- The module uses the new OAuth stack with Java 11

- Now when we go into the browser and try to access the http://127.0.0.1:8080/articles page, 
- we’ll be automatically redirected to the OAuth server login page under http://auth-server:9000/login URL:
- After providing the proper username and password, the authorization server will redirect us back to the requested URL, the list of articles.

- Further requests to the articles endpoint won’t require logging in, as the access token will be stored in a cookie.

### Relevant Articles:

- [Spring Security OAuth Authorization Server](https://www.baeldung.com/spring-security-oauth-auth-server)
- [Add Authorities as Custom Claims in JWT Access Tokens in Spring Authorization Server](https://www.baeldung.com/spring-jwt-access-tokens-authorities-custom-claims)

### Description

OAuth is an open standard that describes a process of authorization. It can be used to authorize user access to an API. For example, a REST API can restrict access to only registered users with a proper role.

An OAuth authorization server is responsible for authenticating the users and issuing access tokens containing the user data and proper access policies.

In this tutorial, we’ll implement a simple OAuth application using the Spring Security OAuth Authorization Server project.

In the process, we’ll create a client-server application that will fetch a list of Baeldung articles from a REST API. Both the client services and server services will require an OAuth authentication.
