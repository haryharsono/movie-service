package com.haryharsono.movie.service.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Double rating;
    private String image;
    private Date createdAt;
    private Date updatedAt;
}
