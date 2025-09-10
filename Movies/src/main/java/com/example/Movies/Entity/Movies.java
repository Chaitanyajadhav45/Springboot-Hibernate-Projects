package com.example.Movies.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Movies_Table")

public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Movie_Name")
    private String name ;

    @Column(name = "Duration")
    private double duration ;

    @Column(name = "Language")
    private String language ;

    @Column(name = "Director")
    private  String director ;

    @Column(name = "IMDB_Rating")
    private double imdb ;

    public Movies(){}

    public Movies(String name, double duration, String language, String director, double imdb) {
        this.name = name;
        this.duration = duration;
        this.language = language;
        this.director = director;
        this.imdb = imdb;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", language='" + language + '\'' +
                ", director='" + director + '\'' +
                ", imdb=" + imdb +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDirector() {
        return director;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }
}
