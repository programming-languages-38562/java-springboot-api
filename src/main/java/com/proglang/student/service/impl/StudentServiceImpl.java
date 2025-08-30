package com.proglang.student.service.impl;

import com.proglang.student.model.Student;
import com.proglang.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> students = new HashMap<>();
    private Long currentId = 1L; // Start from 1
    @Override
    public Student addStudent(Student student) {
        if (student.getPkStudentID() == null || student.getPkStudentID() <= 0) {
            student.setPkStudentID(currentId++);
        } else if (students.containsKey(student.getPkStudentID())) {
            throw new IllegalArgumentException("Student with ID " + student.getPkStudentID() + " already exists.");
        }

        students.put(student.getPkStudentID(), student);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Student getStudentById(Long pkStudentID) {
        return students.get(pkStudentID);
    }

    @Override
    public Student updateStudent(Long pkStudentID, Student student) {
        if (students.containsKey(pkStudentID)) {
            students.put(pkStudentID, student);
            return student;
        }
        return null;
    }

    @Override
    public boolean deleteStudent(Long pkStudentID) {
        return students.remove(pkStudentID) != null;
    }
}
