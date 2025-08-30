package com.springboot.galagar_springboot_api.Service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.springboot.galagar_springboot_api.Model.Student;

@Service
public class StudentServiceImpl implements StudentServices {

    private Map<Long, Student> studentDB = new HashMap<>();
    private long idCounter = 1;

    @Override
    public List<Student> getAllStudent() {
        return new ArrayList<>(studentDB.values());
    }

    @Override
    public Optional<Student> getStudentById(long id) {
        return Optional.ofNullable(studentDB.get(id));
    }

    @Override
    public Student addStudent(Student student) {
        if (student.getPkStudentID() == 0) {
            student.setPkStudentID(idCounter++);
        }
        studentDB.put(student.getPkStudentID(), student);
        return student;
    }

    @Override
    public Student updateStudent(long id, Student student) {
        if (studentDB.containsKey(id)) {
            student.setPkStudentID(id); // keep ID consistent
            studentDB.put(id, student);
            return student;
        } else {
            throw new RuntimeException("Student with ID " + id + " not found.");
        }
    }

    @Override
    public boolean deleteStudent(long id) {
        return studentDB.remove(id) != null;
    }
}
