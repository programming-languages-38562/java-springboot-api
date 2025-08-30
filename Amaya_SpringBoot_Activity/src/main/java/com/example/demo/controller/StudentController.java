package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.services.impl.StudentServiceImpl;

@RestController
@RequestMapping({"/api"})
public class StudentController {
   @Autowired
   private StudentServiceImpl studentServiceImpl;

   public StudentController() {
   }

   @GetMapping({"/students"})
   public ResponseEntity<List<Student>> getAllStudents() {
      return ResponseEntity.status(200).body(this.studentServiceImpl.getAllStudents());
   }

   @GetMapping({"/students/{id}"})
   public ResponseEntity<?> getStudentById(@PathVariable Long id) {
      Optional<Student> student = this.studentServiceImpl.getStudentById(id);
      return student.isPresent() ? ResponseEntity.status(200).body(student) : ResponseEntity.status(404).body("Student not found.");
   }

   @PostMapping({"/students"})
   public ResponseEntity<Student> addStudent(@RequestBody Student student) {
      return ResponseEntity.status(201).body(this.studentServiceImpl.addStudent(student));
   }

   @PutMapping({"students/{id}"})
   public ResponseEntity<?> updateInformation(@PathVariable Long id, @RequestBody Student student) {
      Optional<Student> stud = this.studentServiceImpl.getStudentById(id);
      if (!stud.isPresent()) {
         return ResponseEntity.status(404).body("Student not found.");
      } else {
         Student updatedStudent = this.studentServiceImpl.updateStudent(id, student);
         return ResponseEntity.status(200).body(updatedStudent);
      }
   }

   @DeleteMapping({"/students/{id}"})
   public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
      boolean foundAndDeleted = this.studentServiceImpl.deleteStudent(id);
      return foundAndDeleted ? ResponseEntity.status(200).body("Student deleted.") : ResponseEntity.status(404).body("Student not found.");
   }
}
