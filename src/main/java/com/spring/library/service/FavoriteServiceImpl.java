package com.spring.library.service;

import com.spring.library.model.Favorite;
import com.spring.library.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService{
    @Autowired
    FavoriteRepository favoriteRepository;
    @Override
    public void save(Favorite favorite) {
        favoriteRepository.save(favorite);
    }

    @Override
    @Transactional
    public void deleteByBookId(int id) {
        favoriteRepository.deleteByBookId(id);
    }

    @Override
    public boolean existsByBookIdAndUserId(int bookId, int userId) {
        return favoriteRepository.existsByBookIdAndUserId(bookId,userId);
    }

    @Override
    public List<Integer> findAllBookIdsByUserId(int userId) {
        return favoriteRepository.findAllBookIdsByUserId(userId);
    }
}
