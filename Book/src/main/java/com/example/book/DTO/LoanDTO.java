package com.example.book.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
public class LoanDTO {
    @NotNull(message = "userID cannot be null")
    private Integer userID;
    @NotNull(message = "bookID cannot be null")
    private Integer bookID;
}
