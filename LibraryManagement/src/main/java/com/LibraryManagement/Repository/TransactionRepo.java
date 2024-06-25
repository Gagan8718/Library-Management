package com.LibraryManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.LibraryManagement.model.Transaction;

import jakarta.transaction.Transactional;


@Transactional
public interface TransactionRepo extends JpaRepository<Transaction,Integer> {


    @Query("select t from Transaction t where t.card.id=:card_id and t.book.id=:book_id and t.transactionStatus=:status and t.isIssueOperation=:isIssue")
    public List<com.LibraryManagement.model.Transaction> findByCard_Book(@Param("card_id") int card_id,
                                            @Param("book_id") int book_id,
                                            @Param("status") com.LibraryManagement.model.TransactionStatus successful,
                                            @Param("isIssue") boolean isIssue);


//	public List<com.LibraryManagement.model.Transaction> findByCard_Book(int cardId, int bookId,
//			com.LibraryManagement.model.TransactionStatus successful, boolean isIssue);



}