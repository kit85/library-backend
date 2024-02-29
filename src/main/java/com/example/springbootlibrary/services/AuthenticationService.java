package com.example.springbootlibrary.services;

import com.example.springbootlibrary.DTO.AuthenticationResponse;
import com.example.springbootlibrary.DTO.SignInRequest;
import com.example.springbootlibrary.DTO.SignUpRequest;
import com.example.springbootlibrary.Enum.Role;
import com.example.springbootlibrary.entity.User;
import com.example.springbootlibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final  UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationService(UserService userService, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationResponse signup(SignUpRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);

        user = userService.save(user);
        String jwt = jwtService.generateToken(user);

        return new AuthenticationResponse(jwt);
    }

    public AuthenticationResponse signin(SignInRequest request) {
        // Authenticera användaren
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = (User) authentication.getPrincipal();

        String jwtToken = jwtService.generateToken(user);


        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(jwtToken);

        return response;
    }
}
