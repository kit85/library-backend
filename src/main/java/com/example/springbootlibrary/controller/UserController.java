package com.example.springbootlibrary.controller;

import com.example.springbootlibrary.DTO.AuthenticationResponse;
import com.example.springbootlibrary.DTO.SignInRequest;
import com.example.springbootlibrary.DTO.SignUpRequest;
import com.example.springbootlibrary.services.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

 private final AuthenticationService authenticationService;

    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public AuthenticationResponse signup(@RequestBody SignUpRequest request){
        return  authenticationService.signup(request);
    }

    @PostMapping("/signin")
    public AuthenticationResponse signup(@RequestBody SignInRequest request){
        return authenticationService.signin(request);
    }






}
