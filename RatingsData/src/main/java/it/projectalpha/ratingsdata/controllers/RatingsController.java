package it.projectalpha.ratingsdata.controllers;

import it.projectalpha.ratingsdata.models.Rating;
import it.projectalpha.ratingsdata.models.UserRating;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("ratings")
@Slf4j
public class RatingsController {

    @RequestMapping("/{movieId}")
    public Rating getRatings(@PathVariable("movieId") Long movieId) {
        log.info("Invoked method RatingsController::getRatings. Retrieving rating for movie with id: {}", movieId);
        return Rating.builder().movieId(movieId).rating(4).build();
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") Long userId) {
        log.info("Invoked method RatingsController::getUserRatings. Retrieving rating for user with id: {}", userId);

        return new UserRating(Arrays.asList(Rating.builder().movieId(1234L).rating(4).build(), Rating.builder().movieId(5678L).rating(3).build()));
    }

}
