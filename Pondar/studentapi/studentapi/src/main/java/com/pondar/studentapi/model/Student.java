package com.pondar.studentapi.model;

public class Student {
    private Long pkStudentId;
    private String name;
    private String course;

    public Student() {
    }

    public Student(Long pkStudentId, String name, String course) {
        this.pkStudentId = pkStudentId;
        this.name = name;
        this.course = course;
    }

    public Long getPkStudentId() {
        return pkStudentId;
    }

    public void setPkStudentId(Long pkStudentId) {
        this.pkStudentId = pkStudentId;
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
