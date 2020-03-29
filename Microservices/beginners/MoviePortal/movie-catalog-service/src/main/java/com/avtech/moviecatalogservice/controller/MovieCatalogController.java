package com.avtech.moviecatalogservice.controller;

import com.avtech.moviecatalogservice.model.Catalog;
import com.avtech.moviecatalogservice.model.MovieInfo;
import com.avtech.moviecatalogservice.model.MovieRating;
import com.avtech.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movie-catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/get/{userId}")
    public List<Catalog> getCatalogList(@PathVariable("userId") String userId){

        UserRating userRating = restTemplate.getForObject("http://movie-ratings-service/api/movie-rating/users/1", UserRating.class);

        return userRating.getUserRatings().stream().map( rating ->{
            MovieInfo movieInfo = restTemplate.getForObject("http://movie-info-service/api/movie-info/get/"+rating.getMovieId(), MovieInfo.class);

//            MovieInfo movieInfo = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/api/movie-info/get/"+rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(MovieInfo.class)
//                    .block();


            return new Catalog(movieInfo.getName(),movieInfo.getDesc(),rating.getRating());
        }).collect(Collectors.toList());

    }
}
