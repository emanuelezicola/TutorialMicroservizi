package it.projectalpha.movieinfo.controllers;

import it.projectalpha.movieinfo.models.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieController {

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") Long movieId) {
        log.info("Invoked method MovieController::getMovieInfo. Retrieving info for Movie with id: {}", movieId);
        return Movie.builder().movieId(movieId).name("Harry Potter ed il Principe Mezzosangue.").build();
    }

}
