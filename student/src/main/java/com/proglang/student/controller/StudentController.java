package com.proglang.student.controller;

import com.proglang.student.model.Student;
import com.proglang.student.service.StudentService;
import com.proglang.student.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{pkStudentID}")
    public Student getStudentById(@PathVariable int pkStudentID) {
        Student student = studentService.getStudentById(pkStudentID);
        if (student == null) throw new StudentNotFoundException("Student with ID " + pkStudentID + " not found");
        return student;
    }

    @PutMapping("/{pkStudentID}")
    public Student updateStudent(@PathVariable int pkStudentID, @RequestBody Student student) {
        Student updated = studentService.updateStudent(pkStudentID, student);
        if (updated == null) throw new StudentNotFoundException("Cannot update. Student with ID " + pkStudentID + " not found");
        return updated;
    }

    @DeleteMapping("/{pkStudentID}")
    public String deleteStudent(@PathVariable int pkStudentID) {
        if (!studentService.deleteStudent(pkStudentID)) {
            throw new StudentNotFoundException("Cannot delete. Student with ID " + pkStudentID + " not found");
        }
        return "Student with ID " + pkStudentID + " deleted successfully";
    }
}
