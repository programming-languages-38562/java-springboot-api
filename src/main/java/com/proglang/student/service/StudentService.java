package com.proglang.student.service;

import com.proglang.student.model.Student;
import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long pkStudentID);
    Student updateStudent(Long pkStudentID, Student student);
    boolean deleteStudent(Long pkStudentID);
}
