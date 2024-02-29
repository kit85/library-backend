package com.example.springbootlibrary;

import com.example.springbootlibrary.Enum.Role;


import com.example.springbootlibrary.config.PasswordConfig;
import com.example.springbootlibrary.entity.User;
import com.example.springbootlibrary.repository.BookRepository;
import com.example.springbootlibrary.repository.UserRepository;
import com.example.springbootlibrary.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;


@SpringBootApplication
@Import(PasswordConfig.class)
public class SpringBootLibraryApplication implements CommandLineRunner {
	@Autowired
	BookRepository bookRepository;

	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final PasswordEncoder passwordEncoder;

	@Autowired
	private final UserService userService;

	//Skapa en LoggerFactory-instans
	private static final Logger logger = LoggerFactory.getLogger(SpringBootLibraryApplication.class);

    public SpringBootLibraryApplication(UserRepository userRepository, PasswordEncoder passwordEncoder, UserService userService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		//user
		/*
		if(userRepository.count() == 0) {
			User user = new User();
			user.setUsername("admin");
			user.setLastname("admin");
			user.setEmail("admin@gmail.com");
			user.setPassword(passwordEncoder.encode("password"));
			user.setRole(Role.ROLE_ADMIN);

			userRepository.save(user);
			logger.debug("Admin user created successfully.");
		}
		//book 1
		/*
		Book book1 = new Book();
		book1.setId(1L);
		book1.setTitle("Python");
		book1.setAuthor("Souad");
		book1.setDescription("Java which is written by Souad");
		book1.setCopies(6);
		book1.setCopiesAvailable(6);
		book1.setCategory("programming");


		String imgPath = "src/main/resources/images/python.png";
		Path imagePath = Paths.get(imgPath);
		byte[] imageData = Files.readAllBytes(imagePath);
		String base64Img = Base64.getEncoder().encodeToString(imageData);
		book1.setImg(base64Img);
		bookRepository.save(book1);
		Book book = bookRepository.findById(1L).orElseThrow(); // Hämta befintlig bok från databasen

		/*
		Review review1 = new Review();
		review1.setBookId(book.getId()); // Ange bokens id i recensionen
		review1.setUserEmail("souad@example.com");
		review1.setRating(5);
		review1.setReviewDescription("Great book!");
		reviewRepository.save(review1); // Spara recensionen till databasen

		 */
		/*

		//book 2
		Book book2 = new Book();
		book2.setId(2L);
		book2.setTitle("Csharp");
		book2.setAuthor("Semir");
		book2.setDescription("Csharp which is written by Semir");
		book2.setCopies(6);
		book2.setCopiesAvailable(6);
		book2.setCategory("machine learning");

		String imgPath2 = "src/main/resources/images/csharp.png";
		Path imagePath2 = Paths.get(imgPath2);
		byte[] imageData2 = Files.readAllBytes(imagePath2);
		String base64Img2 = Base64.getEncoder().encodeToString(imageData2);
		book2.setImg(base64Img2);
		bookRepository.save(book2);

		 */


	}

}
