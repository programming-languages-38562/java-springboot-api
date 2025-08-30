package com.example.SpringbootAct.model;

public class Student {
    private long pkStudentID;
    private String name;
    private String course;

    public Student() {
    }
    public Student(long pkStudentID, String name, String course) {
        this.pkStudentID = pkStudentID;
        this.name = name;
        this.course = course;
    }

    public long getPkStudentID() {
        return pkStudentID;
    }

    public void setPkStudentID(long pkStudentID) {
        this.pkStudentID = pkStudentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty!");
        } else {
            this.name = name;
        }
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}