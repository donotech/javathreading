package com.bdec.hero_sping_data.spring_data_movie;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieReviewsRepository extends CrudRepository<MovieReviews, Integer> {
    List<MovieReviews> findByMovie(Movie movie);

    @Query(value = "SELECT " +
            "new com.bdec.hero_sping_data.spring_data_movie.AggRatings(" +
                "c.movie.movieId as movieId, AVG(c.starRating) as avgRating) "
            + " FROM MovieReviews c GROUP BY c.movie.movieId") //,nativeQuery = true)
    List<AggRatings> avgRatingsPerMovie();

    @Query(value = "SELECT count(*) from movie_reviews where star_rating > ?",nativeQuery = true)
    Long countTotalQuery(Integer ratings);
}
