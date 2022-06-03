package com.example.book.service;

import com.example.book.Exceptions.BookNotFoundException;
import com.example.book.Exceptions.UserNotFoundException;
import com.example.book.model.Book;
import com.example.book.model.Loan;
import com.example.book.model.User;
import com.example.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }
    public void addBooks(Book book){
        bookRepository.save(book);
    }
    public Book findBookByID(Integer id){
        Book book = bookRepository.findById(id).get();
        if(book == null){
            throw new BookNotFoundException("Couldn't find a book with the id"+id);
        }
        return book;
    }
    public void updateBook(Book book){
        bookRepository.save(book);
    }
}
