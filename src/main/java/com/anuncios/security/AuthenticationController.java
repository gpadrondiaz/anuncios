package com.anuncios.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins={ "http://localhost:3000"})
@RestController
public class AuthenticationController {

    @GetMapping(path = "/authenticate")
    public AuthenticationBean authenticate() {
        return new AuthenticationBean("You are authenticated");
    }
}