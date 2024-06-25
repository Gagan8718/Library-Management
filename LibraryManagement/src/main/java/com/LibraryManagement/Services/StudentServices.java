package com.LibraryManagement.Services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LibraryManagement.Repository.CardRepo;
import com.LibraryManagement.Repository.StudentRepo;
import com.LibraryManagement.model.Card;
import com.LibraryManagement.model.Student;

@Service
public class StudentServices {

    Logger logger= LoggerFactory.getLogger(StudentServices.class);
	
    @Autowired
     private StudentRepo studentRepository ;

    @Autowired
    private  CardRepo cardRepository;
    @Autowired
	CardService cardService;




		public void createStudent(Student student) {

			Card card = cardService.createCard(student);
			logger.info("The card for the student{} is created with the card details{}", student, card);

		}

		public int updateStudent(Student student) {
			return studentRepository.updateStudentDetails(student);

    }
    public void deleteStudent(int id ){

        cardService.deactivate(id);
        studentRepository.deleteCustom(id);

    }


	}
