package service.imp;

import database.DataBase;
import enumgenre.Genre;
import models.Movie;
import service.MovieService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MovieServiceImp implements MovieService {

    public MovieServiceImp(){

    }

    @Override
    public List<Movie> getAllMovies() {
        return DataBase.movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for(Movie i : DataBase.movies ){
            if(i.getName().toLowerCase().contains(name)){
                if(!name.isEmpty()){
                    return i;
                }
            }
        }
        return null ;
    }

    @Override
    public List<Movie> findMovieByActorName(String actorName) {
        List<Movie> movieActor = new ArrayList<>();
        for(Movie i : DataBase.movies){
            for (int j = 0; j < 3; j++) {
                if(i.getActors().get(j).getActorFullName().toLowerCase().contains(actorName)){
                    movieActor.add(i);
                }

            }
            }

        return movieActor;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        for(Movie i : DataBase.movies){
            if(i.getYear().equals(year)){
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Movie>  findMovieByProducer(String producerFullName) {
        List<Movie> movieList = new ArrayList<>();
        for(Movie i : DataBase.movies){
            if(i.getProducer().getFullName().toLowerCase().contains(producerFullName)){
                movieList.add(i);
            }
        }
        return movieList;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for(Movie i : DataBase.movies){
            if(i.getGenre().equals(genre)){
                return i;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
        for(Movie i : DataBase.movies){
            for (int j = 0; j < 3; j++) {
                if(i.getActors().get(j).getRole().toLowerCase().contains(role)){
                    return i;
                }
            }


        }
        return null;
    }
}
