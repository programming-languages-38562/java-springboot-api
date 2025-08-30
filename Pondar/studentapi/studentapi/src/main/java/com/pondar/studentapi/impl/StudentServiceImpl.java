package com.pondar.studentapi.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pondar.studentapi.model.Student;
import com.pondar.studentapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> students = new HashMap<>();

    long currentId = 1;

    @Override
    public Student addStudent(Student student) {
        if (student.getPkStudentId() == null) {
            student.setPkStudentId(currentId++);
        }

        students.put(student.getPkStudentId(), student);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if (students.containsKey(id)) {
            students.put(id, student);
            return student;
        }
        return null;
    }

    @Override
    public boolean deleteStudent(Long id) {
        return students.remove(id) != null;
    }
}
