package com._AML_3A.Rest_Api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._AML_3A.Rest_Api.model.Student;
import com._AML_3A.Rest_Api.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }
    
    @SuppressWarnings("deprecation")
	public Student getStudentById(int id) {
    	return repository.getById(id);
    }
    
    public void deleteStudent(int id)
    {
    	repository.deleteById(id);
    }
    
    public Student updateStudentName(int id, String name) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        student.setName(name);  
        return repository.save(student);
    }
}