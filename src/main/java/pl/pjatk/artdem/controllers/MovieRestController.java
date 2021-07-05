package pl.pjatk.artdem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.artdem.contract.Movie;
import services.MovieService;

import java.util.List;

/*------------------------API--------------------------------
* url           metoda:         wynik:
* /movies       GET             status:200 body: json lista filmow
*               POST            status:201 NO_CONTENT, zapisany nowy film
* /movies/{id}  GET             json - film z podanym id
*               PUT             status:201 NO_CONTENT, modyfikacja danych filmy z podanym id
*               DELETE          usunięcie filmu z podanym id
*
* */
@RestController
@RequestMapping("movies")    //localhost:8080/movies
public class MovieRestController {

    final
    MovieService service;

    public MovieRestController(MovieService service) {
        this.service = service;
    }

    @GetMapping()   //localhost:8080/movies
    public ResponseEntity<List<Movie>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getById(@PathVariable("id") int id){
        Movie result = service.getById(id);
        if(result==null)
            return ResponseEntity.notFound().build();
        return  ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        service.saveMovie(movie);
        return ResponseEntity.noContent().build();
/*       //example json:
        {
                "title":"SomeTitle1",
                "category":"SomeCategory1",
                "year":"2001",
                "price":10,
                "isAvailable":true
         }
 */
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") int id,@RequestBody Movie movie){
        Movie result = service.updateMovie(id, movie);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
/*       //example json:
        {
                "title":"SomeTitle1",
                "category":"SomeCategory1",
                "year":"2001",
                "price":10,
                "isAvailable":false
         }
 */
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") int id){
        Movie deletedMovie = service.deleteMovie(id);
        if(deletedMovie==null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

}
