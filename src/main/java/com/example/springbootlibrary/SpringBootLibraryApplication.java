package com.example.springbootlibrary;

import com.example.springbootlibrary.entity.Book;
import com.example.springbootlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootLibraryApplication implements CommandLineRunner {
	@Autowired
	BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Book book1=new Book(1L,"Java","suad","Like to code",6, 6, "programming","book.png");
		Book book2=new Book(2L,"Javascript","semir","code is fun",3, 6, "programming","book.png");
		bookRepository.saveAll(List.of(book1,book2));
	}



}
