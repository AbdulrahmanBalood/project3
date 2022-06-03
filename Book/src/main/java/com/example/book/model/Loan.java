package com.example.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "userID cannot be null")
    private Integer userID;
    @NotNull(message = "bookID cannot be null")
    private Integer bookID;
    @ManyToMany
    private Set<Book> books;

}
