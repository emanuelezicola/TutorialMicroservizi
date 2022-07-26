package it.projectalpha.moviecatalog.controllers;

import it.projectalpha.moviecatalog.exceptions.EntityNotFoundException;
import it.projectalpha.moviecatalog.models.Movie;
import it.projectalpha.moviecatalog.models.MovieCatalog;
import it.projectalpha.moviecatalog.models.UserRating;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("catalog")
@Slf4j
@AllArgsConstructor
public class MovieCatalogController {

    private final RestTemplate restTemplate;
    private final WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<MovieCatalog> getCatalog(@PathVariable("userId") Long userId) {
        log.info("Invoked method MovieCatalogController::getCatalog. Retrieving users catalog.");

        //get all rated movie IDs
        UserRating userRatings = restTemplate.getForObject("http://localhost:8083/ratings/user/" + userId, UserRating.class);
        if (Objects.isNull(userRatings) || Objects.isNull(userRatings.getUserRatings())) {
            throw new EntityNotFoundException("No ratings found with for user with id: " + userId);
        }

        return userRatings.getUserRatings().stream().map(ratingItem -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movie/", Movie.class);
            if (Objects.isNull(movie)) {
                throw new EntityNotFoundException("No movie found with id: " + ratingItem.getMovieId());
            }
            return MovieCatalog.builder().name(movie.getName()).description("Film su maghi.").rating(ratingItem.getRatingValue()).build();

        }).collect(Collectors.toList());

        //for each movie ID, call movie info service and get details

        //Put them all together

    }

}
