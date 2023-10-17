package com.haryharsono.movie.service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MOVIE_TABLE")
public class Movie implements Serializable {
    @Id
    private Long id;
    private String title;
    private String description;
    private Double rating;
    private String image;
    private Date createdAt;
    private Date updatedAt;

}
