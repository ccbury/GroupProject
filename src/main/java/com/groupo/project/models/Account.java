package com.groupo.project.models;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Account {
    private int id;
    private String nickname;
    private String password;
    private List<Movie> movies = new ArrayList<>(); 
    
    public Account() {
    }

    public Account(int id, String nickname, String password, List<Movie> movies) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public List<Movie> getMovies(){
        return movies;
    }
    public void setMovies(List<Movie> movies){
        this.movies = movies;
    }
    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
    
    public String printAccount() {
        String str = this.getId()+" "+this.getNickname()+ " "+this.getPassword();
        return str;
    }
}
