package com.example.springbootlibrary.entity;


import jakarta.persistence.*;

@Entity
@Table(name="checkout")
public class Checkout {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "checkout_date", nullable = false)
    private String checkoutDate;

    @Column(name = "return_date", nullable = false)
    private String returnDate;

    // Relationship
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false, referencedColumnName = "id")
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "email")
    private User user;

    public Checkout() {
    }

    public Checkout(Long id, String userEmail, String checkoutDate, String returnDate, Book book, User user) {
        this.id = id;
        this.userEmail = userEmail;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
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

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
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







