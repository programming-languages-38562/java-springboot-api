package com.springboot.galagar_springboot_api.Model;

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
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
