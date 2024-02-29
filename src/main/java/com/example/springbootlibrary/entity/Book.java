package com.example.springbootlibrary.entity;



import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name= "author", nullable = false)
    private String author;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="copies", nullable = false)
    private int copies;

    @Column(name="copies_available", nullable = false)
    private int copiesAvailable;

    @Column(name = "category", nullable = false)
    private String category;

    @Lob
    @Column(name="img", columnDefinition = "MEDIUMBLOB")
    private String img;

    // Relationship
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Review> reviews;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Checkout> checkouts;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<History> histories;

    public Book() {
    }

    public Book(Long id, String title, String author, String description, int copies, int copiesAvailable, String category, String img) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.copies = copies;
        this.copiesAvailable = copiesAvailable;
        this.category = category;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
