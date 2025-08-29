package com.example.SpringbootActivity.model;

public class Student {
    // Step 2: Attributes (Encapsulation)
    private long pkStudentID;
    private String name;
    private String course;

    // Step 3: Constructors
    // Default constructor
    public Student() {
        // Empty constructor (useful for frameworks like Spring Boot)
    }

    // Parameterized constructor
    public Student(long pkStudentID, String name, String course) {
        this.pkStudentID = pkStudentID;
        this.name = name;
        this.course = course;
    }

    // Step 4: Getters and Setters

    // Getter and Setter for pkStudentID
    public long getPkStudentID() {
        return pkStudentID;
    }

    public void setPkStudentID(long pkStudentID) {
        this.pkStudentID = pkStudentID;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Example of simple validation
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty!");
        } else {
            this.name = name;
        }
    }

    // Getter and Setter for course
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}


