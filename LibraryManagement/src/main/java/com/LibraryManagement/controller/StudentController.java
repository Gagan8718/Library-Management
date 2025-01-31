package com.LibraryManagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagement.Services.StudentServices;
import com.LibraryManagement.model.Student;

@RestController
public class StudentController {

    @Autowired
    private StudentServices studentService;


    @PostMapping("/createStudent")
    public ResponseEntity createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return new ResponseEntity("Student Successfully added to the system", HttpStatus.CREATED);

    }

    @PutMapping("/updateStudent")
    public ResponseEntity updateStudent(@RequestBody Student student){
        int lines=studentService.updateStudent(student);
        return new ResponseEntity("Student updated",HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity deleteStudent(@RequestParam("id")int id){
        studentService.deleteStudent(id);
        return new ResponseEntity("student successfully deleted!!",HttpStatus.OK);
    }



}
