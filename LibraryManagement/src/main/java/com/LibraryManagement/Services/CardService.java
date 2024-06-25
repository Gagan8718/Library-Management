package com.LibraryManagement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LibraryManagement.Repository.CardRepo;
import com.LibraryManagement.model.Card;
import com.LibraryManagement.model.CardStatus;
import com.LibraryManagement.model.Student;

@Service
public class CardService {

	@Autowired
	private CardRepo cardRepository;

	public Card createCard(Student student) {
		Card card = new Card();
		student.setCard(card);
		card.setStudent(student);
		cardRepository.save(card);
		return card;
	}

	public void deactivate(int student_id) {
		cardRepository.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());

	}
}
