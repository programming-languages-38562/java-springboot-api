package com.example.SpringbootActivity.service;

import java.util.List;
import java.util.Optional;

import com.example.SpringbootActivity.model.Student;

public interface StudentService {
    
    // GET: /students
    // Success: 200 OK | Fail: 404 NOT FOUND
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);

    // POST: /students
    // Success: 201 CREATED | Fail: 400 BAD REQUEST
    Student addStudent(Student student);

    // PUT: /students/{id}
    // Success: 200 OK | Fail: 404 NOT FOUND
    Student updateStudent(Long id, Student student);

    // DELETE: /students/{id}
    // Success: 204 NO CONTENT | Fail: 404 NOT FOUND
    boolean deleteStudent(Long id);
}

