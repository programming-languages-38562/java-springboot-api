package com.proglan.atillo.service;

import com.proglan.atillo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long id);

    Student addStudent(Student student);

    Student updateStudent(Long id, Student student);

    boolean deleteStudent(Long id);
}
