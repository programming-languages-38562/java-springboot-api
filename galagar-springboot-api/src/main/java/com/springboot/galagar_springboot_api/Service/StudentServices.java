package com.springboot.galagar_springboot_api.Service;

import java.util.List;
import java.util.Optional;

import com.springboot.galagar_springboot_api.Model.Student;

public interface StudentServices {

    public List<Student> getAllStudent();

    public Optional<Student> getStudentById(long id);

    public Student addStudent(Student student);

    public Student updateStudent(long id, Student student);

    public boolean deleteStudent(long id);

}
