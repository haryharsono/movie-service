package com.haryharsono.movie.service.Service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haryharsono.movie.service.Service.MovieService;
import com.haryharsono.movie.service.dto.MovieDetailsRs;
import com.haryharsono.movie.service.dto.MovieDto;
import com.haryharsono.movie.service.dto.CreateMovieRq;
import com.haryharsono.movie.service.entity.Movie;
import com.haryharsono.movie.service.exceptionHandler.NotFoundException;
import com.haryharsono.movie.service.repository.MovieRepository;
import com.haryharsono.movie.service.validation.ValidationUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    private final ObjectMapper objectMapper;

    private final MovieRepository movieRepository;

    private final ValidationUtil validationUtil;


    @Autowired
    public MovieServiceImpl(ObjectMapper objectMapper, MovieRepository movieRepository, ValidationUtil validationUtil) {
        this.objectMapper = objectMapper;
        this.movieRepository = movieRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public List<MovieDto> listOfMovie() {
        return movieRepository.findAll().stream().map(x -> (objectMapper.convertValue(x, MovieDto.class))).toList().stream().toList();
    }

    @Override
    public MovieDetailsRs detailsmovie(Long req) {
            Movie movie = movieRepository.findById(req).orElseThrow(() -> new NotFoundException("Not FOund"));
            return objectMapper.convertValue(movie, MovieDetailsRs.class);
    }

    @Override
    public void createMovie(CreateMovieRq movie) {
        validationUtil.validate(movie);
        movieRepository.saveAndFlush(objectMapper.convertValue(movie,Movie.class));

    }

    @Override
    @Transactional
    public void updatedsmovie(Long id,CreateMovieRq req) {
            validationUtil.validate(req);
            Movie movie = movieRepository.findById(id).orElseThrow(()->new NotFoundException("Id Not Found"));
            movie.setTitle(req.getTitle());
            movie.setDescription(req.getTitle());
            movie.setRating(req.getRating());
            movie.setCreatedAt(req.getCreatedAt());
            movie.setImage(req.getImage());
            movieRepository.saveAndFlush(movie);
    }

    @Override
    public void deletedsmovie(Long req) {
            Movie movie = movieRepository.findById(req).orElseThrow(()->new NotFoundException("Id Not Found"));
            movieRepository.delete(movie);
    }
}
