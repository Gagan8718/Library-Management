package com.LibraryManagement.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LibraryManagement.Repository.BookRepo;
import com.LibraryManagement.model.Book;
import java.util.List;
@Service
public class BookServices{
    @Autowired
    BookRepo bookRepository; 
    public void createBook(Book book){
        bookRepository.save(book);
    }
    public List<Book> getBooks(String genre, boolean isAvailable,String author){

        if (genre!=null&&author!=null){
            return bookRepository.findBooksByGenre_Author(genre,author,isAvailable);
        }
        else if (genre!=null){
            return bookRepository.findBooksByGenre(genre,isAvailable);
        }
        else if (author!=null){
            return bookRepository.findBooksByAuthor(author,isAvailable);
        }
        return bookRepository.findBooksByAvailability(isAvailable);    
}
}