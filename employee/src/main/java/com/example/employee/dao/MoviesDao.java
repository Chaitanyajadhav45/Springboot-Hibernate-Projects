package com.example.employee.dao;

import com.example.employee.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesDao extends JpaRepository<Movies, Integer> {
}
