
package com.LibraryManagement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LibraryManagement.Repository.AuthorRepo;
import com.LibraryManagement.model.Author;

@Service
public class AuthorService {
    @Autowired
   private  AuthorRepo authorRepository;

	public void createAuthor(Author author) {
		authorRepository.save(author);

	}

	public void updateAuthor(Author author) {
		authorRepository.updateAuthorDetails(author);
	}

	public void deleteAuthor(int id) {
		authorRepository.deleteCustom(id);
	}
}
