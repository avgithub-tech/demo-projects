package com.avtech.movieinfoservice.controller;

import com.avtech.movieinfoservice.model.MovieInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie-info")
public class MovieInfoController {

    @GetMapping("/get/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable("movieId") int movieId){
        return new MovieInfo(1,"Lagaan","Awsome movie");
    }
}
