package com.LibraryManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagement.Services.BookServices;
import com.LibraryManagement.model.Book;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class BookController {

    @Autowired
    private  BookServices bookService;
    @PostMapping("/createBook")
    public ResponseEntity createBook(@RequestBody Book book) {

        bookService.createBook(book);
        return new ResponseEntity("Book added to the library system", HttpStatus.ACCEPTED);

    }
    @SuppressWarnings("unchecked")
	

    @GetMapping("/getBooks")
    public ResponseEntity getBooks(@RequestParam(value = "genre", required = false) String genre,
                                   @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
                                   @RequestParam(value = "author", required = false) String author) {

        List<Book> bookList = bookService.getBooks(genre, available, author);
        return new ResponseEntity(bookList, HttpStatus.OK);
    }

    


}