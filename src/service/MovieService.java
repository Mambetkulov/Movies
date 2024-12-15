package service;

import enumgenre.Genre;
import models.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie findMovieByFullNameOrPartName(String name);

    List<Movie> findMovieByActorName(String actorName);

    Movie findMovieByYear(LocalDate year);

    List <Movie> findMovieByProducer(String producerFullName);

    Movie findMovieByGenre(Genre genre);

    Movie findMovieByRole(String role);
}
