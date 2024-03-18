package com.example.springbootlibrary.controller;

import com.example.springbootlibrary.DTO.AuthenticationResponse;
import com.example.springbootlibrary.DTO.SignInRequest;
import com.example.springbootlibrary.DTO.SignUpRequest;
import com.example.springbootlibrary.services.AuthenticationService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/user")
@CrossOrigin("http://localhost:3000")
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
