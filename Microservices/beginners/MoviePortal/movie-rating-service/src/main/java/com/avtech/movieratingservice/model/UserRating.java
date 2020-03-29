package com.avtech.movieratingservice.model;

import java.util.List;

public class UserRating {

    public UserRating(){}

    public UserRating(List<MovieRating> userRatings) {
        this.userRatings = userRatings;
    }

    private List<MovieRating> userRatings;

    public List<MovieRating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<MovieRating> userRatings) {
        this.userRatings = userRatings;
    }
}
