package com.example.book.controller;

import com.example.book.DTO.LoanDTO;
import com.example.book.DTO.ResponseAPI;
import com.example.book.model.Loan;
import com.example.book.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/loan")
public class LoanController {
    Logger logger = LoggerFactory.getLogger(LoanController.class);
    private final LoanService loanService;
    @GetMapping
    public ResponseEntity<List<Loan>> getLoans(){
        logger.info("getLoans in Loan controller used");
        return ResponseEntity.status(200).body(loanService.getLoans());
    }
    @PostMapping
    public ResponseEntity<ResponseAPI> addLoan(@RequestBody @Valid LoanDTO loanDTO){
        logger.info("addLoan in Loan controller used");
        loanService.addLoan(loanDTO);
        return ResponseEntity.status(201).body(new ResponseAPI("Loan added",201));
    }
    @PostMapping("/loan/{userID}/{bookID}")
    public ResponseEntity<ResponseAPI> loanBook(@PathVariable Integer userID,@PathVariable Integer bookID){
        loanService.lendBook(userID,bookID);
        return ResponseEntity.status(201).body(new ResponseAPI("Book loaned successfully",201));
    }
    @GetMapping("/returnbook/{bookID}")
    public ResponseEntity<ResponseAPI> returnBook(@PathVariable Integer bookID){
        loanService.returnLendedBooks(bookID);
        return ResponseEntity.status(200).body(new ResponseAPI("Book returned",200));
    }
}
