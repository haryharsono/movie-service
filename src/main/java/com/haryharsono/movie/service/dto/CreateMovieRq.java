package com.haryharsono.movie.service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class CreateMovieRq implements Serializable {
    @Size(min = 1 , max = 255)
    private String title;
    @Size(min = 1 , max = 255)
    private String description;
    @NotNull
    private Double rating;
    @Size(min = 1 , max = 255)
    private String image;
    private Date createdAt;
    private Date updatedAt;
}
