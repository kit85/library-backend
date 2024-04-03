package com.example.springbootlibrary.DTO;

import java.util.Date;

public class ReviewResponse {

    private Long id;
    private Date date;
    private int rating;
    private String reviewDescription;
    private Long bookId;
    private Long userId;

    public ReviewResponse() {
    }

    public ReviewResponse(Long id, Date date, int rating, String reviewDescription, Long bookId, Long userId) {
        this.id = id;
        this.date = date;
        this.rating = rating;
        this.reviewDescription = reviewDescription;
        this.bookId = bookId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
