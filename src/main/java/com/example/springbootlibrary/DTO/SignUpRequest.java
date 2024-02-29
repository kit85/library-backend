package com.example.springbootlibrary.DTO;

public class SignUpRequest {
    private String username;
    private String lastname;

    private String email;

    private String password;

    public SignUpRequest() {
    }

    public SignUpRequest(String username, String lastname, String email, String password) {
        this.username = username;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
