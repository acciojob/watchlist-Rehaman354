package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieData=new HashMap<>();//movie name,movie object
    HashMap<String,Director> directorData=new HashMap<>();//director name,director object
    HashMap<String, List<String>> directorMoviesDb=new HashMap<>();//director is key->list of movies is value

}
