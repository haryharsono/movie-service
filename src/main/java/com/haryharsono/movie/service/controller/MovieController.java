package com.haryharsono.movie.service.controller;


import com.haryharsono.movie.service.Service.MovieService;
import com.haryharsono.movie.service.dto.CreateMovieRq;
import com.haryharsono.movie.service.dto.MovieDetailsRs;
import com.haryharsono.movie.service.dto.MovieDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<MovieDto> listMovieController(){
        return  movieService.listOfMovie();
    }
    @GetMapping("/movies/{id}")
    public MovieDetailsRs listMovieController(@Valid @PathVariable(value = "id",required = true) Long id){
        return  movieService.detailsmovie(id);
    }
    @PostMapping("/movies")
    public void createMoviecontroller( @RequestBody CreateMovieRq createMovieRq){
        movieService.createMovie(createMovieRq);
    }
    @PatchMapping("/movies/{id}")
    public void updateMoviecontroller(@Valid @PathVariable(value = "id",required = true)Long id, @RequestBody CreateMovieRq createMovieRq){
        movieService.updatedsmovie(id,createMovieRq);
    }
    @DeleteMapping("/movies/{id}")
    public void deletedMoviecontroller(@Valid @PathVariable(value = "id",required = true)Long id){
        movieService.deletedsmovie(id);
    }
}
