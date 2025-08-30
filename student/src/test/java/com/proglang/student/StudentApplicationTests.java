package com.proglang.student;

import com.proglang.student.model.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentApplicationTests {

    @Test
    void testStudentModel() {
        // create student using constructor
        Student student = new Student(1, "John Doe", "CS");

        // verify data
        assertEquals(1L, student.getPkStudentID());
        assertEquals("John Doe", student.getName());
        assertEquals("CS", student.getCourse());

        // update student data using setters
        student.setName("Jane Doe");
        student.setCourse("IT");

        assertEquals("Jane Doe", student.getName());
        assertEquals("IT", student.getCourse());
    }
}
