package com.example.springbootlibrary.entity;


import jakarta.persistence.*;


@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email", nullable = false)
    private String userEmail;
    @Column(name = "title")
    private String title;

    @Column(name = "question", columnDefinition = "text")
    private String question;

    @Column(name = "admin_email")
    private String adminEmail;

    @Column(name = "response", columnDefinition = "text")
    private String response;

    @Column(name = "closed")
    private boolean closed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Message() {
    }

    public Message(Long id, String userEmail, String title, String question, String adminEmail, String response, boolean closed, User user) {
        this.id = id;
        this.userEmail = userEmail;
        this.title = title;
        this.question = question;
        this.adminEmail = adminEmail;
        this.response = response;
        this.closed = closed;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


