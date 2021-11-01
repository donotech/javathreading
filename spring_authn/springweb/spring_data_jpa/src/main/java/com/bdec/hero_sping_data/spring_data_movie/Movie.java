package com.bdec.hero_sping_data.spring_data_movie;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private String name;
    private Date releaseDate;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<MovieReviews> movieReviews;

    protected Movie(){}

    public Movie(String name, Date releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.movieReviews = movieReviews;
    }

    public Set<MovieReviews> getMovieReviews() {
        return movieReviews;
    }

    public void setMovieReviews(Set<MovieReviews> movieReviews) {
        this.movieReviews = movieReviews;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movieId +
                ", name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
