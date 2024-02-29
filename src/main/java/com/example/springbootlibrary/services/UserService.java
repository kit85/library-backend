package com.example.springbootlibrary.services;

import com.example.springbootlibrary.entity.User;
import com.example.springbootlibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService  {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService(){
            @Override
            public UserDetails loadUserByUsername(String username){
                return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
            }
        };
    }


    public User save(User newUser) {
        if(newUser.getId() == null){
            newUser.setCreatedAt(LocalDateTime.now());
        }
        newUser.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(newUser);
    }
}

