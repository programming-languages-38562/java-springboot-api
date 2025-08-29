package com.villegas.student_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.villegas.student_api.model.Student;
import com.villegas.student_api.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET all students
    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();

        if (allStudents.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Student Found");
        }

        return ResponseEntity.ok(allStudents);
    }

    // GET student by ID
    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        Optional<Student> foundStudent = studentService.getStudentById(id);

        if (foundStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Student %d is not found", id));
        }

        return ResponseEntity.ok(foundStudent.get());
    }

    // POST - add new student
    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        if (student.getName() == null || student.getName().isEmpty() || student.getCourse() == null || student.getCourse().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name and course are required");
        }
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    // PUT - update existing student
    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);

        if (updatedStudent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        return ResponseEntity.ok(updatedStudent);
    }

    // DELETE - remove student
    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudent(id);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Student %d is not found", id));
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
