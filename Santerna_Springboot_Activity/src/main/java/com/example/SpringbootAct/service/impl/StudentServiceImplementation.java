package com.example.SpringbootAct.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.SpringbootAct.model.Student;
import com.example.SpringbootAct.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService {

    private final Map<Long, Student> studentDB = new HashMap<>();

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDB.values());
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return Optional.ofNullable(studentDB.get(id));
    }

    @Override
    public Student addStudent(Student student) {
        studentDB.put(student.getPkStudentID(), student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        if (studentDB.containsKey(id)) {
            Student student = studentDB.get(id);
            student.setName(updatedStudent.getName());
            student.setCourse(updatedStudent.getCourse());

            studentDB.put(id, student);
            return student;
        } else {
            return null; 
        }
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (studentDB.containsKey(id)) {
            studentDB.remove(id);
            return true; 
        }
        return false; 
    }
}