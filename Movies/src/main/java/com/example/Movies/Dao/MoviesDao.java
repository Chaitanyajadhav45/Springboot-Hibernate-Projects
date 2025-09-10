package com.example.Movies.Dao;

import com.example.Movies.Entity.Movies;
import jakarta.transaction.Transactional;

public interface MoviesDao {

    @Transactional
    void save(Movies movies);

    Movies findById(int id);

    @Transactional
    void updateLanguage(int id,String newLanguage);

    @Transactional
    void updateDuration(int id, double newDuration);

    @Transactional
    void updateImdb(int id, double newImdb);

    @Transactional
    void deleteById(int id);
}
