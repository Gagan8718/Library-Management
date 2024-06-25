 package com.LibraryManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.LibraryManagement.Repository.AdminRepo;
import com.LibraryManagement.Repository.AuthorRepo;
import com.LibraryManagement.Repository.BookRepo;
import com.LibraryManagement.Repository.CardRepo;
import com.LibraryManagement.Repository.StudentRepo;

@SpringBootApplication
public class LibraryManagementApplication  {

 @Autowired
private AdminRepo adminRepository;
	@Autowired
	private StudentRepo studentRepository;

	@Autowired
	private CardRepo  cardRepository;


	@Autowired
	 private AuthorRepo authorRepository;

	@Autowired
	private BookRepo  bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	
		
	}


//	@Override
//	public void run(String... args)throws Exception {
//
////		Student student =new Student("abc@gnail.com","saikat",21,"India");
////
////		Card card=new Card();
////		card.setStudent(student);//Mainly providing you with a two ways relationship
////		student.setCard(card);
////
////		cardRepository.save(card);
////		studentRepository.updateStudentEmail("abc@gnail.com","abc@1234");
////
////		Author author=new Author("Saikat","sai@gmail.com",56,"India");
////		Book book=new Book("Intro to Physics", Genre.PHYSICS,author);
////		author.setBooks_written(Arrays.asList(book));
////		authorRepository.save(author);
////		cardRepository.findAll().stream().forEach(System.out::println);
//
//
//		//Saving the parent automatically saves the student
//
//
//	}
//}
