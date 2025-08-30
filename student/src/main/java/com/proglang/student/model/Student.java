package com.proglang.student.model;

public class Student {
    private int pkStudentID;
    private String name;
    private String course;

    // Parameterized constructor
    public Student(int pkStudentID, String name, String course) {
        this.pkStudentID = pkStudentID;
        this.name = name;
        this.course = course;
    }

    public Student(){}
    
    // Getters
    public int getPkStudentID() {
        return pkStudentID;
    }
    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
    
    // Setters
    public void setPkStudentID(int pkStudentID) {
        this.pkStudentID = pkStudentID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    
    
}


