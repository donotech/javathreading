package com.bdec.hero_sping_data.spring_data_movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringDataMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMovieApplication.class, args);
	}


	public CommandLineRunner mappingDemo2() {
		return args -> {
			System.out.println("My app started");
		};
	}

	@Bean
	public CommandLineRunner mappingDemo(MovieRepository movieRepository,
										 MovieReviewsRepository movieReviewsRepository) {
		return args -> {

			// create a new book
			Movie movie= new Movie("Some Movie1", new Date());
			Movie movie2 = new Movie("Second movie", new Date());

			// save the book
			movieRepository.save(movie);
			movieRepository.save(movie2);

			MovieReviews r1 = new MovieReviews(movie, "random reviewer1", 4, "good movie");
			MovieReviews r2 = new MovieReviews(movie2, "random reviewer1", 1, "bad movie");
			MovieReviews r3 = new MovieReviews(movie, "random reviewer2", 4, "good movie");
			MovieReviews r4 = new MovieReviews(movie2, "random reviewer2", 4, "good movie");
			List<MovieReviews> reviewsList = new ArrayList<>();
			reviewsList.add(r1);
			reviewsList.add(r2);
			reviewsList.add(r3);
			reviewsList.add(r4);

			movieReviewsRepository.saveAll(reviewsList);

			List<MovieReviews> movieReviews = movieReviewsRepository.findByMovie(movie);
			movieReviews.forEach(System.out::println);

            Long totalRecords  = movieReviewsRepository.countTotalQuery(3);
			System.out.println("Total records: " + totalRecords);
			System.out.println("Printing avg rating per movie");
			List<AggRatings> ratingsAgg = movieReviewsRepository.avgRatingsPerMovie();
			ratingsAgg.forEach(System.out::println);
		};
	}

}
