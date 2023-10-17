package com.haryharsono.movie.service.Service.impl;

import com.haryharsono.movie.service.Service.MovieService;
import com.haryharsono.movie.service.dto.movie.MovieDetailsRs;
import com.haryharsono.movie.service.dto.movie.MovieDto;
import com.haryharsono.movie.service.dto.movie.movieDetailsRq;
import com.haryharsono.movie.service.entity.Movie;
import com.haryharsono.movie.service.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> listOfMovie() {
        return movieRepository.findAll().stream().map(this::mapperToMovieDto).toList().stream().toList();
    }

    @Override
    public MovieDetailsRs detailsmovie(movieDetailsRq req) {
        return null;
    }

    @Override
    public void createMovie(movieDetailsRq req) {

    }

    @Override
    public void updatedsmovie(movieDetailsRq req) {

    }

    @Override
    public void deletedsmovie(movieDetailsRq req) {

    }
    private MovieDto mapperToMovieDto(Movie movie){
        return MovieDto
                .builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .image(movie.getImage())
                .description(movie.getDescription())
                .rating(movie.getRating())
                .createdAt(movie.getCreatedAt())
                .updatedAt(movie.getUpdatedAt())
                .build();
    }
}
