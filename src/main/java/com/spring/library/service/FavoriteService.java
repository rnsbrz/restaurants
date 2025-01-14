package com.spring.library.service;

import com.spring.library.model.Favorite;

import java.util.List;

public interface FavoriteService {
    void save(Favorite favorite);
    void deleteByBookId(int id);
    boolean existsByBookIdAndUserId(int bookId, int userId);
    List<Integer> findAllBookIdsByUserId(int userId);
}
