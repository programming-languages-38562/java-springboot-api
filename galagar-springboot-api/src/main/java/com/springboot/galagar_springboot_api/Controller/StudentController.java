package com.springboot.galagar_springboot_api.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.galagar_springboot_api.Model.Student;
import com.springboot.galagar_springboot_api.Service.StudentServices;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentServices studentService;
    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable long id) {
        Optional<Student> studentOptional = studentService.getStudentById(id);

        if (studentOptional.isPresent()) {
            return ResponseEntity.ok(studentOptional.get());
        } else {
            return ResponseEntity.status(404).body("Student with ID " + id + " not found");
        }
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
         return ResponseEntity.ok(studentService.addStudent(student));
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable long id, @RequestBody Student updatedData) {
        Optional<Student> studentOptional = studentService.getStudentById(id);

        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();

            if (updatedData.getName() != null && !updatedData.getName().isEmpty()) {
                existingStudent.setName(updatedData.getName());
            }

            if (updatedData.getCourse() != null && !updatedData.getCourse().isEmpty()) {
                existingStudent.setCourse(updatedData.getCourse());
            }

            studentService.updateStudent(id, existingStudent);

            return ResponseEntity.ok(existingStudent);
        } else {
            return ResponseEntity.status(404).body("Student with ID " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable long id) {
        Optional<Student> studentOptional = studentService.getStudentById(id);

        if (studentOptional.isPresent()) {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student with ID " + id + " has been deleted.");
        } else {
            return ResponseEntity.status(404).body("Student with ID " + id + " not found.");
        }
    }
}


