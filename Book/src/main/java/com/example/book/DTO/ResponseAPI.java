package com.example.book.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Setter @Getter
public class ResponseAPI {
    private String message;
    private Integer statusCode;
}
