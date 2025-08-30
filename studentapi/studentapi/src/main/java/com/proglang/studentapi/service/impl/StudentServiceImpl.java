package com.proglang.studentapi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proglang.studentapi.model.Student;
import com.proglang.studentapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private Map<Long, Student> studentDB = new HashMap<>();
    private long idCounter = 0000001;

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDB.values());
    }

    @Override
    public Optional<Student> getStudentByID(Long pkStudentID) {
        return Optional.ofNullable(studentDB.get(pkStudentID));
    }

    @Override
    public Student addStudent(Student student) {

        if (student.getPkStudentID() == 0) {
            student.setPkStudentID(idCounter++);
        }

        studentDB.put(student.getPkStudentID(), student);

        return studentDB.get(student.getPkStudentID());
        
    }

    @Override
    public Student updateStudent(Long ID, Student student) {
        
        if (studentDB.containsKey(ID)) {
            studentDB.put(ID, student);
            return studentDB.get(student.getPkStudentID());
        } else {
            return null;
        }
        
    }

    @Override
    public boolean deleteStudent(Long ID) {

        return studentDB.remove(ID) != null;

    }

}
