package com.proglang.student.service;

import com.proglang.student.model.Student;
import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int pkStudentID);
    Student updateStudent(int pkStudentID, Student student);
    boolean deleteStudent(int pkStudentID);
}
