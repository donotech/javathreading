package com.bdec.hero_sping_data.spring_data_movie;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findByName(String name);
}
