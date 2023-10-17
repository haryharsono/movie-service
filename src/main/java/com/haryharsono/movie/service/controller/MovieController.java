package com.haryharsono.movie.service.controller;


import com.haryharsono.movie.service.Service.MovieService;
import com.haryharsono.movie.service.dto.movie.MovieDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/listmovie")
    public List<MovieDto> listMovieController(){
        return  movieService.listOfMovie();
    }
}
