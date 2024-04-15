package com.example.demoauth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentInfo{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "student_id")
private long studentId;
@Column(name = "student_roll_no")
private int studentRollNo;
@Column(name = "student_class")
private int studentClass;
@Column(name = "student_name")
private String studentName;
@Column(name = "parent_name")
private String parentName;
@Column(name = "parent_email")
private String parentEmail;

    public StudentInfo(long studentId, int studentRollNo, int studentClass, String studentName, String parentName, String parentEmail) {
        this.studentId = studentId;
        this.studentRollNo = studentRollNo;
        this.studentClass = studentClass;
        this.studentName = studentName;
        this.parentName = parentName;
        this.parentEmail = parentEmail;
    }

    public StudentInfo() {}

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(int studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "studentId=" + studentId +
                ", studentRollNo=" + studentRollNo +
                ", studentClass=" + studentClass +
                ", studentName='" + studentName + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentEmail='" + parentEmail + '\'' +
                '}';
    }
}
