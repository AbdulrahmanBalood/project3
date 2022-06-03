package com.example.book.repository;


import com.example.book.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {
   Loan findByBookID(Integer bookID);
}
