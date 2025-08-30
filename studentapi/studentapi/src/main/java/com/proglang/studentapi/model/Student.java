package com.proglang.studentapi.model;

public class Student {

    private long pkStudentID;
    private String name;
    private String course;

    public Student() {} // default constructor

    // parameterized constructor
    public Student(long pkStudentID, String name, String course) {
        this.pkStudentID = pkStudentID;
        this.name = name;
        this.course = course;
    }

    // getters
    public long getPkStudentID() {
        return pkStudentID;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    // setters
    public void setPkStudentID(long pkStudentID) {
        this.pkStudentID = pkStudentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
