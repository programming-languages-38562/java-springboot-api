package com.pondar.studentapi.service;

import com.pondar.studentapi.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long pkStudentID);
    Student updateStudent(Long pkStudentID, Student student);
    boolean deleteStudent(Long pkStudentID);
}
