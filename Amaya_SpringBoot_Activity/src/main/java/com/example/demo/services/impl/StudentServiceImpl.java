package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
   private Map<Long, Student> studentDB = new HashMap();
   private Long pkStudentId = 1L;

   public StudentServiceImpl() {
   }

   @Override
   public List<Student> getAllStudents() {
      return new ArrayList<>(this.studentDB.values());
   }

   @Override
   public Optional<Student> getStudentById(Long id) {
      return Optional.ofNullable((Student)this.studentDB.get(id));
   }

   @Override
   public Student addStudent(Student student) {
      if (student.getPkStudentID() == 0L) {
         Long var2 = this.pkStudentId;
         this.pkStudentId = this.pkStudentId + 1L;
         student.setPkStudentID(var2);
      }

      this.studentDB.put(student.getPkStudentID(), student);
      return student;
   }

   @Override
   public Student updateStudent(Long id, Student student) {
      Student existingStudent = (Student)this.studentDB.get(id);
      if (existingStudent == null) {
         return null;
      } else {
         if (student.getName() != null && !existingStudent.getName().equals(student.getName())) {
            existingStudent.setName(student.getName());
         }

         if (student.getCourse() != null && !existingStudent.getCourse().equals(student.getCourse())) {
            existingStudent.setCourse(student.getCourse());
         }

         return existingStudent;
      }
   }

   @Override
   public boolean deleteStudent(Long id) {
      Student student = (Student)this.studentDB.get(id);
      if (student != null) {
         this.studentDB.remove(id);
         return true;
      } else {
         return false;
      }
   }
}
