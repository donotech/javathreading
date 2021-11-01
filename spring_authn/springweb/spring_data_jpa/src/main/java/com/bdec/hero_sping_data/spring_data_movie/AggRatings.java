package com.bdec.hero_sping_data.spring_data_movie;

public class AggRatings {
    Integer movieId;
    Double avgRating;

    @Override
    public String toString() {
        return "AggRatings{" +
                "movieId=" + movieId +
                ", avgRating=" + avgRating +
                '}';
    }

    protected AggRatings() {}

    public AggRatings(Integer movieId, Double avgRating) {
        this.movieId = movieId;
        this.avgRating = avgRating;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }
}
