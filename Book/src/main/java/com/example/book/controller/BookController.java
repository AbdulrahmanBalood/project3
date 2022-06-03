package com.example.book.controller;

import com.example.book.DTO.ResponseAPI;
import com.example.book.model.Book;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/book")
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;
    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        logger.info("getBooks in book controller used");
        return ResponseEntity.status(200).body(bookService.getBooks());
    }
    @PostMapping
    public ResponseEntity<ResponseAPI> addBook(@RequestBody @Valid Book book){
        logger.info("addBook in book controller used");
        bookService.addBooks(book);
        return ResponseEntity.status(201).body(new ResponseAPI("Book added",201));
    }
}
