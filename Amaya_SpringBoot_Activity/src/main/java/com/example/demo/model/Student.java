package com.example.demo.model;

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
      return this.pkStudentID;
   }

   public String getName() {
      return this.name;
   }

   public String getCourse() {
      return this.course;
   }

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
