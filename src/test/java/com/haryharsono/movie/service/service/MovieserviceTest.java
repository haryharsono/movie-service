package com.haryharsono.movie.service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haryharsono.movie.service.Service.impl.MovieServiceImpl;
import com.haryharsono.movie.service.dto.CreateMovieRq;
import com.haryharsono.movie.service.dto.MovieDetailsRs;
import com.haryharsono.movie.service.entity.Movie;
import com.haryharsono.movie.service.repository.MovieRepository;
import com.haryharsono.movie.service.validation.ValidationUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class MovieserviceTest {

    @Mock
    MovieRepository movieRepository;

    @Mock
    ValidationUtil validationUtil;
    @Mock
    ObjectMapper objectMapper;

    @InjectMocks
    MovieServiceImpl movieService;

    Movie movie;
    @Before
    public void before(){
        movie = new Movie(1L,"Pengabdi Setan 2 Comunion","dalam sebuah film horor indonesia  tahun 2022 yang disutradarai dan ditulis oleh joko Anwar sebagai sekuel dari film 2017, pengabdi setan.",7.0,"",new Date(),new Date());
    }

    @Test
    public void create_test_movie_succes(){
        CreateMovieRq createMovieRq = CreateMovieRq
                .builder()
                .createdAt(new Date())
                .title("Anjoy")
                .image("")
                .updatedAt(new Date())
                .rating(8.5)
                .description("")
                .build();
        Movie movie = new Movie();
        doNothing().when(validationUtil).validate(createMovieRq);
        when(objectMapper.convertValue(createMovieRq, Movie.class)).thenReturn(movie);
        movieService.createMovie(createMovieRq);
        verify(movieRepository, times(0)).saveAndFlush(movie);

    }
    @Test
    public void create_test_movie_failed(){
        CreateMovieRq createMovieRq = CreateMovieRq
                .builder()
                .createdAt(new Date())
                .title("Anjoy")
                .image("")
                .updatedAt(new Date())
                .rating(9.5)
                .description("")
                .build();
        Movie movie = new Movie();
        doNothing().when(validationUtil).validate(createMovieRq);
        when(objectMapper.convertValue(createMovieRq, Movie.class)).thenReturn(movie);
        movieService.createMovie(createMovieRq);
        Mockito.doThrow(new RuntimeException("Database error")).when(movieRepository).saveAndFlush(movie);
        assertThrows(RuntimeException.class, () -> movieService.createMovie(createMovieRq));

    }

    @Test
    public void details_test_movie_succes(){
        MovieDetailsRs anjoy = MovieDetailsRs.builder()
                .createdAt(new Date())
                .title("Anjoy")
                .image("")
                .updatedAt(new Date())
                .rating(9.5)
                .description("")
                .id(1L)
                .build();
        Movie movie = new Movie();
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));

        when(objectMapper.convertValue(movie, MovieDetailsRs.class)).thenReturn(anjoy);
        MovieDetailsRs detailsmovie = movieService.detailsmovie(1L);
        assertEquals(anjoy, detailsmovie);

    }





}
