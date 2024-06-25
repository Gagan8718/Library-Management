package com.LibraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LibraryManagement.model.AdminBean;

public interface AdminRepo extends JpaRepository<AdminBean, Integer> {
	AdminBean findByUsername(String username);
}
