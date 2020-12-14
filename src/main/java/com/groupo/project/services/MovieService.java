package com.groupo.project.services;

import com.groupo.project.databases.Database;
import com.groupo.project.models.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    Database d = new Database();
    private List<Movie> movie = d.getMoviesDB();
    
    public List<Movie> getAllMovies() {
        return movie;
    }
    
    public Movie getCustomer(int id) {
        return movie.get(id-1);
    }
    
    public Movie createMovie(Movie m) {
        m.setId(movie.size() + 1);
	movie.add(m);
	System.out.println("201 - resource created with path: /messages/" + String.valueOf(m.getId()));
	return m;
    }
    
    public Movie deleteMovie (Movie m){
        m.getId();
        movie.remove(m);
        System.out.println("The following movie has been removed: "+m.getTitle());
        return m;
    }
    
    public List<Movie> getSearchAccounts(String title) {
        List<Movie> matcheslist = new ArrayList<>();
      
        for (Movie q: getAllMovies()) {
            if ((title == null || q.getTitle().equals(title))) {
               matcheslist.add(q);
            }
        }
        return matcheslist;
    } 
}
