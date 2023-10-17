package com.haryharsono.movie.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@AllArgsConstructor
@Data
public class webResponse<T> {
    private int code;
    private String status;
    private T message;
}
