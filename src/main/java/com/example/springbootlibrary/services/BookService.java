package com.example.springbootlibrary.services;

import com.example.springbootlibrary.entity.Book;
import com.example.springbootlibrary.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(final BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

}
