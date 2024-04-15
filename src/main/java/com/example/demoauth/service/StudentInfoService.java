package com.example.demoauth.service;

import com.example.demoauth.entity.StudentInfo;
import com.example.demoauth.repository.StudentInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {

    private StudentInfoRepository studentInfoRepository;

    public StudentInfoService(StudentInfoRepository studentInfoRepository) {
        this.studentInfoRepository = studentInfoRepository;
    }

    public String addStudent(StudentInfo studentInfo) {
        studentInfoRepository.save(studentInfo);
        return "Student Added Successfully";
    }
    public void deleteUser(long id){
        studentInfoRepository.deleteById(id);
    }
    public List<StudentInfo> getStudents(StudentInfo studentInfo){
        List<StudentInfo>students=studentInfoRepository.findAll();
        return students;
    }
}
