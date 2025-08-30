package com.proglang.studentapi.service;

import java.util.List;
import java.util.Optional;

import com.proglang.studentapi.model.Student;

public interface StudentService {
    public List<Student> getAllStudents();
    public Optional<Student> getStudentByID(long ID);
    public Student addStudent(Student student);
    public Student updateStudent(Long id, Student student);
    public boolean deleteStudent(long ID);
}
