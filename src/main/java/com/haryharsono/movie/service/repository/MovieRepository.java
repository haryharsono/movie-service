package com.haryharsono.movie.service.repository;

import com.haryharsono.movie.service.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
