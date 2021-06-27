package com.example.demo.services;

import com.example.demo.contract.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class MovieService {

    private List<Movie> db = new ArrayList<Movie>();

    public List<Movie> getAll(){
        return this.db;
    }

    public Movie getById(int id){
        Optional<Movie> result =  db.stream().filter(p->p.getID()==id).findFirst();
        if(result.isPresent())
            return result.get();
        return null;
    }

    public Movie delete(int id){
        Movie result = getMovieById(id);
        if (result == null) return null;
        db.remove(result);
        return result;
    }

    public void saveMovie(Movie movie){
        OptionalInt lastId = db.stream().map(p->p.getID()).mapToInt(x->x).max();
        if(!lastId.isPresent())
            movie.setID(1);
        else movie.setID(lastId.getAsInt()+1);
        db.add(movie);
    }

    public Movie Update(int id, Movie movie){
        Movie result = getMovieById(id);
        if (result == null) return null;
        result.setNazwa(movie.getNazwa());
        result.setKategoria(movie.getKategoria());
        result.setRok_wydania(movie.getRok_wydania());
        return result;
    }

    private Movie getMovieById(int id2) {
        Optional<Movie> fromList = db.stream().filter(p -> p.getID() == id2).findFirst();
        if (!fromList.isPresent()) return null;
        Movie result = fromList.get();
        return result;
    }
}
