package com.proglan.atillo.service.impl;

import com.proglan.atillo.model.Student;
import com.proglan.atillo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> studentDB = new HashMap<>();
    private Long pkStudentIdCounter = 1L;

    @Override
    public List<Student> getAllStudents() {
        return List.copyOf(studentDB.values());
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return Optional.ofNullable(studentDB.get(id));
    }

    @Override
    public Student addStudent(Student student) {
        if (student.getPkStudentId() == 0) {
            student.setPkStudentId(pkStudentIdCounter++);
        }
        studentDB.put(student.getPkStudentId(), student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student update = studentDB.get(id);
        if (update == null) return null;

        if(student.getName() != null) update.setName(student.getName());
        if(student.getCourse() != null) update.setCourse(student.getCourse());
        return update;
    }

    @Override
    public boolean deleteStudent(Long id) {
        return studentDB.remove(id) != null;
    }
}
