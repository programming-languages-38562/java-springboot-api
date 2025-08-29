package com.villegas.student_api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.villegas.student_api.model.Student;
import com.villegas.student_api.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> studentDB = new HashMap<>();
    private long studentCount = 1L; 

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
        if (student.getPkStudentId() == null) {
            student.setPkStudentId(studentCount++);
        }
        studentDB.put(student.getPkStudentId(), student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if (!studentDB.containsKey(id)) {
            return null;
        }        
        Student existing = studentDB.get(id);

        if (student.getName() != null) {
            existing.setName(student.getName());
        }
        if (student.getCourse() != null) {
            existing.setCourse(student.getCourse());
        }

        studentDB.put(id, existing);
        return existing;
    }
    @Override
    public boolean deleteStudent(Long id) {
        return studentDB.remove(id) != null;
    }
}
