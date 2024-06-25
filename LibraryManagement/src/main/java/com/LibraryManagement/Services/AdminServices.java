package com.LibraryManagement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LibraryManagement.Repository.AdminRepo;
import com.LibraryManagement.model.AdminBean;

@Service
public class AdminServices {
	 @Autowired
   private  AdminRepo    adminRepository;
 @Autowired
 private AuthorService authorService;
   
    public AdminServices(AdminRepo userRepository) {
        this.adminRepository = userRepository;
    }

    public AdminBean register(AdminBean user) {
    return this.adminRepository.save(user);
    	
 
    }

    public boolean authenticate(String username, String password) {
      AdminBean adminBean = this.adminRepository.findByUsername(username);
      if(adminBean != null) {
    	  
    	  if(password.equals(adminBean.getPassword()))return true;
      }
        return false;
    }
}