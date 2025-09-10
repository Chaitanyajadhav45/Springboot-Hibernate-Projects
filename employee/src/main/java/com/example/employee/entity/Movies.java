package com.example.employee.entity;

import jakarta.persistence.*;

@Entity
@Table(name="movies")

public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="Movie_id")
    private int id;

    @Column(name="Movie_Name")
    private String name;

    @Column(name="Movie_Director")
    private String director ;

    @Column(name="Movie_Budget")
    private double budget;

    @Column(name="Movie_Duration")
    private String duration ;

    public Movies() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movies(String name, String director, double budget, String duration) {

        this.name = name;
        this.director = director;
        this.budget = budget;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", budget=" + budget +
                ", duration='" + duration + '\'' +
                '}';
    }
}
