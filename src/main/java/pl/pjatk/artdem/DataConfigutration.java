package pl.pjatk.artdem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.MovieService;

@Configuration
public class DataConfigutration {

    @Bean
    public MovieService movieService(){
        return new MovieService();
    }
}
