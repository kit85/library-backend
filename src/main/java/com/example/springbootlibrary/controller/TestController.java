package com.example.springbootlibrary.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping("/everyone")
    public String everyone(){
            return "everyone can this";
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String usersEndpoint(){
        return "Only User can see this";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String AdminEndPoint(){
        return "Only ADMIN can see this";
    }


}
