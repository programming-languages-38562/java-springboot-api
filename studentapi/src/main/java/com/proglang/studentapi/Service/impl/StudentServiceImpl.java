package com.proglang.studentapi.Service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proglang.studentapi.Student;
import com.proglang.studentapi.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

    private Map<Long, Student> studentDB = new HashMap<>();

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDB.values());
    }

    @Override
    public Optional<Student> getStudentId(Long id) {
        return Optional.ofNullable(studentDB.get(id));
    }

    @Override
    public Student addStudent(Student student) {
        studentDB.put(student.getpkStudentID(), student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if(studentDB.containsKey(id)) {
            studentDB.put(id, student);
            return student;
        }
        return null;
    }

    @Override
    public Boolean deleteStudent(Long id) {
        if(studentDB.containsKey(id)) {
            studentDB.remove(id);
            return true;
        }

        return false;
    }
}
