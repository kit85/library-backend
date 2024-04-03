package com.example.springbootlibrary.controller;

import com.example.springbootlibrary.DTO.ReviewRequest;
import com.example.springbootlibrary.DTO.ReviewResponse;
import com.example.springbootlibrary.entity.Review;
import com.example.springbootlibrary.entity.User;
import com.example.springbootlibrary.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/reviews")
@CrossOrigin("http://localhost:3000")
public class ReviewController {

    private final ReviewService reviewService;

    private static final Logger logger = LoggerFactory.getLogger(Review.class);

    public ReviewController(ReviewService reviewService, AuthenticationManager authenticationManager) {
        this.reviewService = reviewService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<ReviewResponse>> findAllReviews() {
        try {
            List<ReviewResponse> reviewResponses = reviewService.findAllReviews();
            return ResponseEntity.ok(reviewResponses);
        } catch (Exception e) {
            // Logga exception
            logger.error("Ett fel uppstod vid hämtning av recensioner", e);
            // Returnera ett anpassat felmeddelande
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    @PostMapping("/add")
    public ResponseEntity<?> addReview(@RequestBody ReviewRequest reviewRequest, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        reviewService.addReview(reviewRequest, user.getId());
        return ResponseEntity.ok("Review added successfully");
    }

}
