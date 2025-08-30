package com.example.SpringbootAct.service;

import java.util.List;
import java.util.Optional;

import com.example.SpringbootAct.model.Student;

public interface StudentService {
    
    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long id);

    Student addStudent(Student student);

    Student updateStudent(Long id, Student student);

    boolean deleteStudent(Long id);
}
