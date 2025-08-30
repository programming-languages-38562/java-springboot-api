package com.proglang.student.model;

public class Student {
    private Long pkStudentID;
    private String name;
    private String course;

    // Parameterized constructor
    public Student(Long pkStudentID, String name, String course) {
        this.pkStudentID = pkStudentID;
        this.name = name;
        this.course = course;
    }

    public Student(){}
    
    // Getters
    public Long getPkStudentID() {
        return pkStudentID;
    }
    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
    
    // Setters
    public void setPkStudentID(Long pkStudentID) {
        this.pkStudentID = pkStudentID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    
    
}


