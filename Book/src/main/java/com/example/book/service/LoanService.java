package com.example.book.service;

import com.example.book.DTO.LoanDTO;
import com.example.book.model.Book;
import com.example.book.model.Loan;
import com.example.book.model.User;
import com.example.book.repository.BookRepository;
import com.example.book.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final UserService userService;
    private final BookService bookService;
    public List<Loan> getLoans(){
        return loanRepository.findAll();
    }
    public void addLoan(LoanDTO loanDTO){
        User user = userService.findUserByID(loanDTO.getUserID());
        Book book = bookService.findBookByID(loanDTO.getBookID());
        System.out.println("book: "+book+" bookName: "+book.getName());
        Set<Book> books = new HashSet<>();
        books.add(book);
        Loan loan = new Loan(null,loanDTO.getUserID(),loanDTO.getBookID(),books);
        loanRepository.save(loan);
    }
    public void lendBook(Integer userID, Integer bookID){
        User user = userService.findUserByID(userID);
        Book book = bookService.findBookByID(bookID);
        Set<Book> books = books = new HashSet<>();
        books.add(book);
        Loan loan = new Loan(null,userID,bookID,books);
        Set<Loan> loans = book.getLoans();

        if(loans == null){
            loans = new HashSet<>();
        }
        loans.add(loan);
        loanRepository.save(loan);
        bookService.updateBook(book);

    }
    public void returnLendedBooks(Integer bookID){
        Book book = bookService.findBookByID(bookID);
        Loan loan = loanRepository.findByBookID(bookID);
        Set<Book> books = loan.getBooks();
        books.remove(book);
        Set<Loan> loans = book.getLoans();
        loans.remove(loan);
        loanRepository.save(loan);
        bookService.updateBook(book);
    }
}
