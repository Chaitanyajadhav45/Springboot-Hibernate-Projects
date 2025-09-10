package com.example.Movies;

import com.example.Movies.Dao.MoviesDao;
import com.example.Movies.Entity.Movies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class MoviesApplication {

    @Bean
    public CommandLineRunner commandLineRunner(MoviesDao moviesDao) {
        return runner -> {
            Scanner sc = new Scanner(System.in);

            boolean flag = true;
            while (flag) {
                System.out.println("\n---------- MOVIES MENU ----------");
                System.out.println("1: Insert Movies");
                System.out.println("2: Search Movie by Id");
                System.out.println("3: Update Movie");
                System.out.println("4: Remove Movie by Id");
                System.out.println("0: Exit");

                System.out.print("Choose Option : ");
                int opt = sc.nextInt();
                sc.nextLine();

                switch (opt) {
                    case 0: {
                        System.out.println("Exiting...");
                        flag = false;
                        break;
                    }

                    case 1: {
                        System.out.print("How Many Movies You Want To Enter : ");
                        int times = sc.nextInt();
                        sc.nextLine();

                        while (times > 0) {
                            System.out.print("Enter Movie Name : ");
                            String name = sc.nextLine();

                            System.out.print("Enter Duration(mins) : ");
                            double duration = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Enter Language : ");
                            String language = sc.nextLine();

                            System.out.print("Enter Director : ");
                            String director = sc.nextLine();

                            System.out.print("Enter IMDB Rating : ");
                            double imdb = sc.nextDouble();
                            sc.nextLine();

                            Movies m1 = new Movies(name, duration, language, director, imdb);
                            moviesDao.save(m1);
                            times--;
                        }
                        System.out.println("Movies Saved Successfully !!");
                        break;
                    }

                    case 2: {
                        System.out.print("Enter Id: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        Movies m2 = moviesDao.findById(id);
                        System.out.println(m2 != null ? m2 : "Movie not found!");
                        break;
                    }

                    case 3: {
                        System.out.print("Enter Movie Id : ");
                        int movieId = sc.nextInt();
                        sc.nextLine();

                        Movies movie = moviesDao.findById(movieId);
                        if (movie == null) {
                            System.out.println("Movie not found!");
                            break;
                        }

                        boolean updating = true;
                        while (updating) {
                            System.out.println("\n--------- Update Menu ---------");
                            System.out.println("1: Update Language");
                            System.out.println("2: Update Duration");
                            System.out.println("3: Update IMDB Rating");
                            System.out.println("0: Exit to Movies Menu");

                            System.out.print("Choose option: ");
                            int option = sc.nextInt();
                            sc.nextLine();

                            switch (option) {
                                case 0: {
                                    updating = false;
                                    break;
                                }
                                case 1: {
                                    System.out.print("Enter New Language: ");
                                    String newLang = sc.nextLine();
                                    moviesDao.updateLanguage(movieId, newLang);
                                    break;
                                }
                                case 2: {
                                    System.out.print("Enter New Duration: ");
                                    double newDuration = sc.nextDouble();
                                    sc.nextLine();
                                    moviesDao.updateDuration(movieId, newDuration);
                                    break;
                                }
                                case 3: {
                                    System.out.print("Enter New IMDB Rating: ");
                                    double newImdb = sc.nextDouble();
                                    sc.nextLine();
                                    moviesDao.updateImdb(movieId, newImdb);
                                    break;
                                }
                                default: {
                                    System.out.println("Invalid Option");
                                    break;
                                }
                            }
                        }
                        break;
                    }

                    case 4: {
                        System.out.print("Enter Movie Id to Delete: ");
                        int deleteId = sc.nextInt();
                        sc.nextLine();
                        moviesDao.deleteById(deleteId);
                        break;
                    }

                    default: {
                        System.out.println("Invalid option!");
                        break;
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }
}
