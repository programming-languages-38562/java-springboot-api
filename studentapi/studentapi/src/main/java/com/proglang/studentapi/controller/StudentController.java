package com.proglang.studentapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proglang.studentapi.model.Student;
import com.proglang.studentapi.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController  {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{ID}")
    public Optional<Student> getStudentByID(@PathVariable Long ID) {
        return studentService.getStudentByID(ID);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/students/{ID}")
    public Student updateStudent(@PathVariable Long ID, @RequestBody Student student) {
         if (studentService.updateStudent(ID, student) == null) {
             throw new IllegalArgumentException("Student not found");
         }

         return studentService.updateStudent(ID, student);
    }

    @DeleteMapping("/students/{ID}")
    public boolean deleteStudent(@PathVariable Long ID) {
        if (!studentService.deleteStudent(ID)) {
            throw new IllegalArgumentException("Student does not exist");
        }

        return studentService.deleteStudent(ID);
    }

}
