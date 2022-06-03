package com.example.book.Exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }
}
