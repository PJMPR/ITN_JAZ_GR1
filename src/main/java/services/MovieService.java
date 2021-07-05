package services;

import org.springframework.stereotype.Service;
import pl.pjatk.artdem.contract.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class MovieService {

    private List<Movie> db = new ArrayList<>();

    public List<Movie> getAll(){
        return this.db;
    }

    public Movie getById(int id){
        Optional<Movie> result = db.stream().filter(p->p.getId()==id).findFirst();
        if(result.isPresent())
            return  result.get();
        return null;
    }

    public void saveMovie(Movie movie){
        OptionalInt lastId = db.stream().map(p->p.getId()).mapToInt(x->x).max();
        if(!lastId.isPresent())
            movie.setId(1);
        else
            movie.setId(lastId.getAsInt()+1);
        db.add(movie);
    }

    public  Movie updateMovie(int id, Movie movie){
        Optional<Movie> fromList = db.stream().filter(p->p.getId()==id).findFirst();
        if(!fromList.isPresent()) return null;
        Movie result = fromList.get();
        result.setAvailable(movie.isAvailable());
        result.setCategory(movie.getCategory());
        result.setPrice(movie.getPrice());
        result.setTitle(movie.getTitle());
        result.setYear(movie.getYear());
        return result;
    }

    public Movie deleteMovie(int id){
        Optional<Movie> fromList = db.stream().filter(p->p.getId()==id).findFirst();
        if(!fromList.isPresent()) return null;
        Movie result = fromList.get();
        db.remove(result);
        return result;
    }
}
