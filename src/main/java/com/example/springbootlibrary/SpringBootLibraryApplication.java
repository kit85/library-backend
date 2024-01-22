package com.example.springbootlibrary;

import com.example.springbootlibrary.entity.Book;
import com.example.springbootlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Base64;
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
		Book book1 = new Book();
		book1.setId(1L);
		book1.setTitle("Python");
		book1.setAuthor("Souad");
		book1.setDescription("Java which is written by Souad");
		book1.setCopies(6);
		book1.setCopiesAvailable(6);
		book1.setCategory("programming");
		// Hämta bild i base64-format
		String imgPath = "src/main/resources/images/python.png";
		String base64Image =  convertImageToBase64(imgPath);
		book1.setImg(base64Image);
		// Spara boken i databasen
		bookRepository.save(book1);

		Book book2 = new Book();
		book2.setId(2L);
		book2.setTitle("CSHARP");
		book2.setAuthor("Semir");
		book2.setDescription("Csharp which is written by Semir");
		book2.setCopies(6);
		book2.setCopiesAvailable(6);
		book2.setCategory("programming");
		String imgPath2 = "src/main/resources/images/csharp.png";
		String base64Image2 = convertImageToBase64(imgPath2);
		book2.setImg(base64Image2);
		bookRepository.save(book2);

	}

	private String convertImageToBase64(String filePath) throws Exception {
		// Skapa en fil med den givna sökvägen
		File file = new File(filePath);

		try (FileInputStream fileInputStream = new FileInputStream(file)) {
			// Läs filens innehåll till en byte-array
			byte[] bytes = new byte[(int) file.length()];
			fileInputStream.read(bytes);

			// Konvertera filens innehåll till Base64
			String base64Image = Base64.getEncoder().encodeToString(bytes);
			// Skapa en SHA-256-hash av den Base64-kodade bilden
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(base64Image.getBytes());
			// Konvertera hashen till Base64-format och förkorta den
			String shortenedBase64 = Base64.getEncoder().encodeToString(hash);
			// Skriv ut den förkortade hashen (valfritt)
			System.out.println(shortenedBase64);

			// Returnera den förkortade hashen
			return base64Image;
		} catch (IOException e) {
			// Hantera eventuella IO-fel och skriv ut felmeddelandet
			e.printStackTrace();

			// Returnera null om det uppstår ett fel
			return null;
		}
	}



}
