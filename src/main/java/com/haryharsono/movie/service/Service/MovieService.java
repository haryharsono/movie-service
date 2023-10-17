package com.haryharsono.movie.service.Service;


import com.haryharsono.movie.service.dto.MovieDetailsRs;
import com.haryharsono.movie.service.dto.MovieDto;
import com.haryharsono.movie.service.dto.CreateMovieRq;

import java.util.List;


public interface MovieService {

    List<MovieDto> listOfMovie();

    MovieDetailsRs detailsmovie(Long req);

    void createMovie(CreateMovieRq req);

    void updatedsmovie(Long id,CreateMovieRq req);

    void deletedsmovie(Long req);

}
