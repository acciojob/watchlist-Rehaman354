package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieservice;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){

        movieservice.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){

        movieservice.addDirector(director);
        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){

        movieservice.addPair(movie,director);
        return new ResponseEntity<>("New movie-director pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){

        Movie movie = movieservice.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){

        Director director =movieservice.getDirector(name);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{diretor}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){

        List<String> movies =movieservice.getMoviesListOfDirector(director);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){

        List<String> movies =movieservice.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){

        movieservice.deleteDirectorByName(director);
        return new ResponseEntity<>(director+ " removed successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){

        movieservice.deleteAllDirectors();
        return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);
    }

}
