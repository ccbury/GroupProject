package com.groupo.project.resources;

import com.groupo.project.models.Account;
import com.groupo.project.models.Movie;
import com.groupo.project.services.AccountService;
import com.groupo.project.services.MovieService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class MovieResource {
    private MovieService MovieService = new MovieService();
    
    //get all accounts
    @GET
    public List<Movie> getMovies(@PathParam("MovieID") int m_id) {
        return MovieService.getAllMovies();
    }
	
    //create an account
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Movie postMovie(@PathParam("MovieID") int m_id, Movie m) {
        return MovieService.createMovie(m);
    } 
    
}
