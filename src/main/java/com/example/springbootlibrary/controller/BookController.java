package com.example.springbootlibrary.controller;
import com.example.springbootlibrary.entity.Book;
import com.example.springbootlibrary.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    //get all books
    @GetMapping()
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }
    //get book by id
    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id){
        Book book = bookService.findBookById(id);
        if (book !=null){
            return ResponseEntity.ok(book);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    //find book title
    @GetMapping("/search")
    public ResponseEntity<List<Book>> findBookByTitle(@RequestParam String title) {
        List<Book> books = bookService.findBookByTitle(title);
        System.out.println("title: " + title);
        if (!books.isEmpty()) {
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
