package com.LibraryManagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagement.Services.TransactionService; // Import the correct service class
@RestController
public class TransactionController {
@Autowired
 private TransactionService transactionService;


    @PostMapping("/issueBook")
    public ResponseEntity issueBook(@RequestParam(value = "cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception {
        String transaction_id = transactionService.issueBooks(cardId, bookId);
        return new ResponseEntity("Your Transaction was successful. Here is your Txn id: " + transaction_id, HttpStatus.OK);
    }

    
    public ResponseEntity returnBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception {
        String transaction_id = transactionService.returnBooks(cardId, bookId);
        return new ResponseEntity("Your Transaction was successful. Here is your Txn id: " + transaction_id, HttpStatus.OK);
    }
}
