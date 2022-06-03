package com.example.book.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "book name cannot be empty")
    private String name;
    @NotEmpty(message = "genre cannot be empty")
    private String genre;
    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private Set<Loan> loans;


}
