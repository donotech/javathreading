package com.bdec.hero_sping_data.spring_data_movie;

import javax.persistence.*;

@Entity
@Table(name = "movie_reviews")
public class MovieReviews {
    protected MovieReviews() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    private String reviewerName;
    private Integer starRating;
    private String reviewComments;

    public MovieReviews(Movie movie, String reviewerName, Integer starRating, String reviewComments) {
        this.movie = movie;
        this.reviewerName = reviewerName;
        this.starRating = starRating;
        this.reviewComments = reviewComments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }

    @Override
    public String toString() {
        return "MovieReviews{" +
                "id=" + id +
                ", movie=" + movie +
                ", reviewerName='" + reviewerName + '\'' +
                ", starRating=" + starRating +
                ", reviewComments='" + reviewComments + '\'' +
                '}';
    }
}
