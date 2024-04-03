package com.example.springbootlibrary.services;

import com.example.springbootlibrary.DTO.ReviewResponse;
import com.example.springbootlibrary.config.JwtAuthenticationFilter;
import com.example.springbootlibrary.DTO.ReviewRequest;
import com.example.springbootlibrary.entity.Book;
import com.example.springbootlibrary.entity.Review;
import com.example.springbootlibrary.entity.User;
import com.example.springbootlibrary.repository.BookRepository;
import com.example.springbootlibrary.repository.ReviewRepository;
import com.example.springbootlibrary.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final BookRepository bookRepository;
    private final UserRepository userRepository;


    public ReviewService(ReviewRepository reviewRepository, AuthenticationService authenticationService, JwtAuthenticationFilter jwtAuthenticationFilter, JwtService jwtService, AuthenticationManager authenticationManager, BookRepository bookRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }



    public List<ReviewResponse> findAllReviews() {
        // Hämta alla recensioner från databasen och omvandla dem till en ström av recensioner
        return reviewRepository.findAll().stream()
                // För varje recension, omvandla den till en ReviewResponse-objekt
                .map(review -> {
                    // Skapa en ny instans av ReviewResponse för den aktuella recensionen
                    ReviewResponse reviewResponse = new ReviewResponse();
                    // Sätt ID för recensionen i ReviewResponse
                    reviewResponse.setId(review.getId());
                    // Sätt datumet för recensionen i ReviewResponse
                    reviewResponse.setDate(review.getDate());
                    // Sätt betyget för recensionen i ReviewResponse
                    reviewResponse.setRating(review.getRating());
                    // Sätt recensionsbeskrivningen i ReviewResponse
                    reviewResponse.setReviewDescription(review.getReviewDescription());
                    // Hämta bok-ID för recensionen från den tillhörande boken och sätt det i ReviewResponse
                    reviewResponse.setBookId(review.getBook().getId());
                    // Hämta användar-ID för recensionen från den tillhörande användaren och sätt det i ReviewResponse
                    reviewResponse.setUserId(review.getUser().getId());
                    // Returnera det skapade ReviewResponse-objektet för den aktuella recensionen
                    return reviewResponse;
                })
                // Samla in alla ReviewResponse-objekt i en lista
                .collect(Collectors.toList());
    }

    
    public void addReview(ReviewRequest reviewRequest, Long userId) {
        // Hämta användaren från databasen med det angivna användar-ID:et
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Användare med userId " + userId + " hittades inte."));

        // Skapa en ny recension
        Review review = new Review();
        review.setUser(user);
        review.setRating(reviewRequest.getRating());
        review.setReviewDescription(reviewRequest.getDescription());

        // Validera att nödvändig information finns för att spara recensionen
        if (review.getUser() == null || review.getRating() == 0 || review.getReviewDescription() == null || reviewRequest.getBookId() == null) {
            throw new IllegalArgumentException("Nödvändig information saknas för att spara recensionen.");
        }

        // Hämta boken från databasen med det angivna bok-ID:et
        Book book = bookRepository.findById(reviewRequest.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Kunde inte hitta boken med ID: " + reviewRequest.getBookId()));

        // Sätt boken för recensionen
        review.setBook(book);

        // Spara recensionen i databasen
        reviewRepository.save(review);
    }

}
