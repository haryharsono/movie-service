package com.haryharsono.movie.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDetailsRs  implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Double rating;
    private String image;
    private Date createdAt;
    private Date updatedAt;
}
