package com.example.SpringbootActivity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.SpringbootActivity.model.Student;
import com.example.SpringbootActivity.service.StudentService;

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

