package com.spring.library.repositories;

import com.spring.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContainingIgnoreCase(String query);

    List<Book> findByIdIn(List<Integer> ids);
    List<Book> findByGenreId(int genreId);
}