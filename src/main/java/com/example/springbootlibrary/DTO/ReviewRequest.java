package com.example.springbootlibrary.DTO;

public class ReviewRequest {

    private Long bookId;
    private int rating;
    private String description;
    private String userEmail;

    public ReviewRequest() {
    }

    public ReviewRequest(Long bookId, int rating, String description, String userEmail) {
        this.bookId = bookId;
        this.rating = rating;
        this.description = description;
        this.userEmail = userEmail;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
