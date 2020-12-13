package com.groupo.project.resources;

import com.groupo.project.models.Movie;
import com.groupo.project.services.MovieService;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

@Path("/movies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

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
    public Movie postMovie(@PathParam("MovieID")  Movie m) {
        return MovieService.createMovie(m);
    } 
    
}
