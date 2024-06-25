package com.LibraryManagement.model;

import jakarta.persistence.*;

@Entity
public class AdminBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	 @Column(unique = true)
private String username;
private String password;
public AdminBean() {
	super();
	// TODO Auto-generated constructor stub
}
public AdminBean(int id, String username, String password) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



	@Override
	public String toString() {
		return "AdminBean [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
