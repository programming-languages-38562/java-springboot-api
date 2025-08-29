package com.proglan.atillo.model;

public class Student {

    // Attributes

    private long pkStudentId;
    private String name;
    private String course;


    // Constructors

    public Student(long pkStudentId, String name, String course) {
        this.pkStudentId = pkStudentId;
        this.name = name;
        this.course = course;
    }


    public Student() { }

    // Getters
    public long getPkStudentId(){
        return pkStudentId;
    }

    public String getName(){
        return name;
    }

    public String getCourse() {
        return course;
    }

    // Setters

    public void setPkStudentId(long pkStudentId) {
        this.pkStudentId = pkStudentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }


}
