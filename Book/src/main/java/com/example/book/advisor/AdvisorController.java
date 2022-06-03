package com.example.book.advisor;

import com.example.book.DTO.ResponseAPI;
import com.example.book.Exceptions.BookNotFoundException;
import com.example.book.Exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class AdvisorController {
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ResponseAPI> handelUserNotFound(UserNotFoundException userNotFoundException){
        String message = userNotFoundException.getMessage();
        return ResponseEntity.status(400).body(new ResponseAPI(message,400));
    }
    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<ResponseAPI> handleBookNotFound(BookNotFoundException bookNotFoundException){
        String message = bookNotFoundException.getMessage();
        return ResponseEntity.status(400).body(new ResponseAPI(message,400));
    }
    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<ResponseAPI> handleNoSuchElementException(NoSuchElementException noSuchElementException){
        String message = "Book ID or User ID are not valid";
        return ResponseEntity.status(400).body(new ResponseAPI(message,400));
    }
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ResponseAPI> handleConstraintViolationException(ConstraintViolationException constraintViolationException){
        String message = "Please make sure any name isn't empty";
        return ResponseEntity.status(400).body(new ResponseAPI(message,400));
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseAPI> handleMethodArgument(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ResponseAPI(message,400));
    }

}
