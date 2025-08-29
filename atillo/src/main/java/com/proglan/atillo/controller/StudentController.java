package com.proglan.atillo.controller;

import com.proglan.atillo.model.Student;
import com.proglan.atillo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();

        return students.isEmpty()? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        Optional<Student> retrieved = studentService.getStudentById(id);
        return retrieved.isEmpty() ?  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found") :  ResponseEntity.ok(retrieved.get());
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        if(student.getName() == null || student.getCourse() == null || student.getName().isEmpty() || student.getCourse().isEmpty())
            return ResponseEntity.badRequest().body("Required fields should be filled (name and course)");

        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudentById(@PathVariable Long id, @RequestBody Student student){
        Student updated = studentService.updateStudent(id, student);

        return updated == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found") : ResponseEntity.ok(updated);

    }

    @DeleteMapping("students/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudent(id) ? ResponseEntity.ok("Student Deleted") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");
    }

}
