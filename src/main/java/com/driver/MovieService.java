package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepo;
    public void addMovie(Movie movie) {
        movieRepo.movieData.put(movie.getName(),movie);
    }

    public void addDirector(Director director) {
        movieRepo.directorData.put(director.getName(), director);
    }

    public void addPair(String movie, String director) {
        if(movieRepo.directorMoviesDb.containsKey(director))
        {
            List<String> movieList=movieRepo.directorMoviesDb.get(director);
            movieList.add(movie);
            movieRepo.directorMoviesDb.put(director, movieList);
        }
        else {
            List<String> movieList=new ArrayList<>();
            movieList.add(movie);
            movieRepo.directorMoviesDb.put(director, movieList);
        }
    }

    public Movie getMovieByName(String name) {
        return movieRepo.movieData.get(name);
    }

    public Director getDirector(String name) {
        return movieRepo.directorData.get(name);
    }

    public List<String> getMoviesListOfDirector(String director) {
        if(movieRepo.directorMoviesDb.containsKey(director))
        return movieRepo.directorMoviesDb.get(director);
        return new ArrayList<>();
    }

    public List<Movie> getAllMovies() {
        List<Movie> movieList=new ArrayList<>();

        for(Movie movie:movieRepo.movieData.values())
            movieList.add(movie);
        return movieList;
    }

    public void deleteDirectorByName(String director) {
        //removing movies of the director
        List<String> movieList=movieRepo.directorMoviesDb.get(director);
        for(String movie:movieList){
            movieRepo.movieData.remove(movie);
        }
        //removing director
        movieRepo.directorMoviesDb.remove(director);
        movieRepo.directorData.remove(director);
    }

    public void deleteAllDirectors() {
        //removing movies of the director
        for(String director:movieRepo.directorMoviesDb.keySet()) {
            List<String> movieList = movieRepo.directorMoviesDb.get(director);
            for (String movie : movieList) {
                movieRepo.movieData.remove(movie);
            }
        }
        //removing director
        movieRepo.directorMoviesDb.clear();
        movieRepo.directorData.clear();
    }
}
