package com._AML_3A.Rest_Api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com._AML_3A.Rest_Api.model.Student;
import com._AML_3A.Rest_Api.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }
    
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
    	return service.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }
    
    @PostMapping("/{id}")
    public List<Student> deleteStudent(@PathVariable int id){
    	service.deleteStudent(id);
    	return service.getAllStudents();
    }
    
    @PutMapping("/{id}")
    public Student updateStudentName(@PathVariable int id, @RequestBody Student student) {
    	return service.updateStudentName(id, student.getName());
    }
}