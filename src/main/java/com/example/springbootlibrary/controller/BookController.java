package com.example.springbootlibrary.controller;

import com.example.springbootlibrary.entity.Book;
import com.example.springbootlibrary.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping
    public List<Book>getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }




}
