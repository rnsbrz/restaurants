package com.spring.library.service;

import com.spring.library.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void save(Book book);
    List<Book> getAll();
    void deleteById(int id);
    Optional<Book> findById(int id);
    List<Book> findBooksByTitle(String query);

    List<Book> findByIdIn(List<Integer> ids);
}
