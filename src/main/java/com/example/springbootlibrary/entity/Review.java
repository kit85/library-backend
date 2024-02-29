package com.example.springbootlibrary.entity;


import java.util.Date;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email", nullable = false)
    private String userEmail;


    @Column(name = "date")
    @CreationTimestamp
    private Date date;

    @Column(name = "rating")
    private int rating;

   @Column(name = "review_description")
   private String reviewDescription;

    //relationship
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "email")
    private User user;


    public Review() {
    }

    public Review(Long id, String userEmail, Date date, int rating, String reviewDescription, Book book, User user) {
        this.id = id;
        this.userEmail = userEmail;
        this.date = date;
        this.rating = rating;
        this.reviewDescription = reviewDescription;
        this.book = book;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


