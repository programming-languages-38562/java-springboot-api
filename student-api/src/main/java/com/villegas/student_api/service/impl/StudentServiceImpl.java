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

    private final Map<Long, Student> studentMap = new HashMap<>();
    private long studentCount = 1; 

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return Optional.ofNullable(studentMap.get(id));
    }

    @Override
    public Student addStudent(Student student) {
        if (student.getPkStudentId() == null) {
            student.setPkStudentId(studentCount++);
        }
        studentMap.put(student.getPkStudentId(), student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if (!studentMap.containsKey(id)) {
            return null;
        }
        student.setPkStudentId(id);
        studentMap.put(id, student);
        return student;
    }

    @Override
    public boolean deleteStudent(Long id) {
        return studentMap.remove(id) != null;
    }
}
