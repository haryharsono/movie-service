package com.haryharsono.movie.service.Service;


import com.haryharsono.movie.service.dto.movie.MovieDetailsRs;
import com.haryharsono.movie.service.dto.movie.MovieDto;
import com.haryharsono.movie.service.dto.movie.movieDetailsRq;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MovieService {

    List<MovieDto> listOfMovie();

    MovieDetailsRs detailsmovie(movieDetailsRq req);

    void createMovie(movieDetailsRq req);

    void updatedsmovie(movieDetailsRq req);

    void deletedsmovie(movieDetailsRq req);

}
