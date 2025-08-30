package com.student_api.services;

import java.util.List;
import java.util.Optional;

import com.student_api.model.Student;

public interface StudentService {
   List<Student> getAllStudents();

   Optional<Student> getStudentById(Long id);

   Student addStudent(Student student);

   Student updateStudent(Long id, Student student);

   boolean deleteStudent(Long id);
}