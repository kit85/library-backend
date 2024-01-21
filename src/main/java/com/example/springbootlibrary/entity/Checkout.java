package com.example.springbootlibrary.entity;

import jakarta.persistence.*;

@Entity
@Table(name="checkout")
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "checkout_date")
    private String checkoutDate;

    @Column(name = "return_date")
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;



    public Checkout() {
    }

    public Checkout(Long id, String userEmail, String checkoutDate, String returnDate, Book book) {
        this.id = id;
        this.userEmail = userEmail;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
        this.book = book;
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

    @Override
    public String toString() {
        return "Checkout{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", checkoutDate='" + checkoutDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", book=" + book +
                '}';
    }
}
