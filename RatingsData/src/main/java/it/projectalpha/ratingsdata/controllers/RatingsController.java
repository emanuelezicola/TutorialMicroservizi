package it.projectalpha.ratingsdata.controllers;

import it.projectalpha.ratingsdata.models.Rating;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ratings")
@Slf4j
public class RatingsController {

    @RequestMapping("/{movieId}")
    public Rating getRatings(@PathVariable("movieId") Long movieId) {
        log.info("Invoked method RatingsController::getRatings. Retrieving rating for movie with id: {}", movieId);
        return Rating.builder().movieId(movieId).rating(4).build();
    }

}
