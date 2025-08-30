package com.proglang.studentapi;

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


    public long getpkStudentID() {
        return pkStudentID;
    }

    public String getname() {
        return name;
    }

    public String getcourse() {
        return course;
    }

    public void setpkStudent(long pkStudentID) {
        this.pkStudentID = pkStudentID;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setcourse(String course) {
        this.course = course;
    }
}
