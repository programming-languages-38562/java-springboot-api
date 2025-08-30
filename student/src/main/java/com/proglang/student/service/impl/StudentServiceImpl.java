package com.proglang.student.service.impl;

import com.proglang.student.model.Student;
import com.proglang.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Integer, Student> students = new HashMap<>();

    @Override
    public Student addStudent(Student student) {
        students.put(student.getPkStudentID(), student);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Student getStudentById(int pkStudentID) {
        return students.get(pkStudentID);
    }

    @Override
    public Student updateStudent(int pkStudentID, Student student) {
        if (students.containsKey(pkStudentID)) {
            students.put(pkStudentID, student);
            return student;
        }
        return null;
    }

    @Override
    public boolean deleteStudent(int pkStudentID) {
        return students.remove(pkStudentID) != null;
    }
}
