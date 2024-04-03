package com.example.springbootlibrary.repository;

import com.example.springbootlibrary.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    /*
    @Query("SELECT r.id, r.date, r.rating, r.reviewDescription, r.book.id, r.user.id FROM Review r")
    List<Object[]> findAllReviews();

     */

}
