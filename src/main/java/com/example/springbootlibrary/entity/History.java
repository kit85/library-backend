package com.example.springbootlibrary.entity;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name="history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "checkout_date")
    private String checkoutDate;

    @Column(name = "returned_date")
    private String returnedDate;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Lob
    @Column(name = "img")
    private String img;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public History() {
    }

    public History(Long id, String userEmail, String checkoutDate, String returnedDate, String title, String author, String description, String img, Book book) {
        this.id = id;
        this.userEmail = userEmail;
        this.checkoutDate = checkoutDate;
        this.returnedDate = returnedDate;
        this.title = title;
        this.author = author;
        this.description = description;
        this.img = img;
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

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", checkoutDate='" + checkoutDate + '\'' +
                ", returnedDate='" + returnedDate + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", book=" + book +
                '}';
    }
}

