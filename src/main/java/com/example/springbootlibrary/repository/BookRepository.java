package com.example.springbootlibrary.repository;
import com.example.springbootlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book>findByCategoryContaining(String category);
    List<Book> findByTitleContaining(String title);
    //Page<Book> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);
}
