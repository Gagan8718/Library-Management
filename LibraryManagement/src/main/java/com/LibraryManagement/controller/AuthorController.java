
package com.LibraryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagement.Services.AuthorService;
import com.LibraryManagement.model.Author;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping("/createAuthor")
	public ResponseEntity createAuthor(@RequestBody Author author) {
		authorService.createAuthor(author);
		return new ResponseEntity("Author created", HttpStatus.CREATED);
	}

	@PutMapping("/updateAuthor")
	public ResponseEntity updateAuthor(@RequestBody Author author) {
		authorService.updateAuthor(author);
		return new ResponseEntity("Auhtor upadted!!", HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteAuthor")
	public ResponseEntity deleteAuthor(@RequestParam("id") int id) {
		authorService.deleteAuthor(id);
		return new ResponseEntity("Author deleted!!", HttpStatus.ACCEPTED);

	}

}
