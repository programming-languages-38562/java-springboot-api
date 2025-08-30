package com.program.Springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.program.Springboot.model.Student;
import com.program.Springboot.service.StudentService;

@RestController
@RequestMapping("/api")  // All endpoints will start with /api
public class StudentController {

    private final StudentService studentService;

    // Constructor Injection (best practice)
     @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET /api/students → Get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // GET /api/students/{id} → Get student by ID
    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // POST /api/students → Add new student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // PUT /api/students/{id} → Update student
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // DELETE /api/students/{id} → Delete student
    @DeleteMapping("/students/{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}