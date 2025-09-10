package com.example.Movies.Dao.DaoImpl;

import com.example.Movies.Dao.MoviesDao;
import com.example.Movies.Entity.Movies;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Scanner;

@Repository
public class MoviesDaoImpl implements MoviesDao {

    private final EntityManager entityManager ;

    public MoviesDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public  void save(Movies movies){
       entityManager.persist(movies);
    }

    @Override
    public Movies findById(int id)
    {
      return entityManager.find(Movies.class, id);
    }

    @Transactional
    @Override
    public void updateLanguage(int id, String newLanguage) {
        Movies movie = entityManager.find(Movies.class, id);
        if (movie != null) {
            movie.setLanguage(newLanguage);
            entityManager.merge(movie);
            System.out.println("Language updated successfully!");
        } else {
            System.out.println("Movie not found!");
        }
    }

    @Transactional
    @Override
    public void updateDuration(int id, double newDuration) {
        Movies movie = entityManager.find(Movies.class, id);
        if (movie != null) {
            movie.setDuration(newDuration);
            entityManager.merge(movie);
            System.out.println("Duration updated successfully!");
        }
        else {
            System.out.println("Movie not found!");
        }
    }

    @Transactional
    @Override
    public void updateImdb(int id, double newImdb) {
        Movies movie = entityManager.find(Movies.class, id);
        if (movie != null) {
            movie.setImdb(newImdb);
            entityManager.merge(movie);
            System.out.println("IMDB rating updated successfully!");
        }
        else {
            System.out.println("Movie not found!");
        }
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Movies movie = entityManager.find(Movies.class, id);
        if (movie != null) {
            entityManager.remove(movie);
            System.out.println("Movie deleted successfully!");
        }
        else {
            System.out.println("Movie not found!");
        }
    }
}