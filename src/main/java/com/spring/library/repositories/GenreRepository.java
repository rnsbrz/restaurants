package com.spring.library.repositories;

import com.spring.library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Query("SELECT g.name FROM Genre g")
    List<String> findAllGenreNames();
    List<Genre> findByNameContainingIgnoreCase(String query);

    Optional<Genre> findByName(String name);
}
