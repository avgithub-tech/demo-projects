package com.avtech.movieratingservice.controller;

import com.avtech.movieratingservice.model.MovieRating;
import com.avtech.movieratingservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/movie-rating")
public class MovieRatingController {

    @GetMapping("/get/{movieId}")
    public MovieRating getMovieRating(@PathVariable("movieId") int movieId){
        return new MovieRating(1,4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getRatingsForUser(@PathVariable String userId){
        List<MovieRating> ratings = Arrays.asList(
                new MovieRating(1,4),
                new MovieRating(2,5)
        );
        return new UserRating(ratings);
    }
}
