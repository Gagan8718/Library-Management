package com.LibraryManagement.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	private String name;

	@Enumerated(EnumType.STRING)
	private Genre genre;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	Author author;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	Card card;

	@Column(columnDefinition = "TINYINT(1)")
	private boolean available;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Transaction> transactions;

	public Book() {

	}

	public Book(String name, Genre genre, Author author) {
		this.name = name;
		this.genre = genre;
		this.author = author;
		this.available = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isAvailable() {
		return available;
	}
    
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;

	}

	public void setTransactionsstatus(List<Transaction> transactions) {
	    this.transactions = transactions;
	}

}

