package com.proglang.studentapi.Service;
import java.util.List;
import java.util.Optional;


import com.proglang.studentapi.Student;


public interface StudentService {

    
    List<Student> getAllStudents();
    Optional<Student> getStudentId(Long id);
    Student addStudent(Student student);
    Student updateStudent(Long id, Student student);
    Boolean deleteStudent(Long id);


    
}
