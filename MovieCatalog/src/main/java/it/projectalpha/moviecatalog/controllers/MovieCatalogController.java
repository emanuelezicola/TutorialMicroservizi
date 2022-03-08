package it.projectalpha.moviecatalog.controllers;

import it.projectalpha.moviecatalog.exceptions.EntityNotFoundException;
import it.projectalpha.moviecatalog.models.Movie;
import it.projectalpha.moviecatalog.models.MovieCatalog;
import it.projectalpha.moviecatalog.models.Rating;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@Slf4j
public class MovieCatalogController {

    @GetMapping("/{userId}")
    public List<MovieCatalog> getCatalog(@PathVariable("userId") Long userId) {
        log.info("Invoked method MovieCatalogController::getCatalog. Retrieving users catalog.");

        RestTemplate restTemplate = new RestTemplate();

        //get all rated movie IDs
        List<Rating> ratings = Arrays.asList(
                Rating.builder().movieId(1234L).ratingValue(4).build(),
                Rating.builder().movieId(5678L).ratingValue(3).build()
        );

        return ratings.stream().map(ratingItem -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movie/" + ratingItem.getMovieId(), Movie.class);

            if (Objects.isNull(movie)) {
                throw new EntityNotFoundException("No movie found with id: " + ratingItem.getMovieId());
            }

            return MovieCatalog.builder().name(movie.getName()).description("Film su maghi.").rating(ratingItem.getRatingValue()).build();
        }).collect(Collectors.toList());

        //for each movie ID, call movie info service and get details

        //Put them all together

    }

}
