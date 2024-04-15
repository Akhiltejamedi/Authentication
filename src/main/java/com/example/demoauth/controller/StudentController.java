package com.example.demoauth.controller;

import com.example.demoauth.entity.StudentInfo;
import com.example.demoauth.service.StudentInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    private StudentInfoService studentInfoService;

    public StudentController(StudentInfoService studentInfoService) {
        this.studentInfoService = studentInfoService;
    }

    @PostMapping("/addNewStudent")
    public String addStudent(@RequestBody StudentInfo studentInfo)
    {
        return studentInfoService.addStudent(studentInfo);
    }
    @DeleteMapping("removeStudent/{id}")
    public void removeUser(@PathVariable long id){

        studentInfoService.deleteUser(id);
    }
    @GetMapping("getStudents")
    public List<StudentInfo> getStudents(StudentInfo studentInfo){
        return studentInfoService.getStudents(studentInfo);
    }


}
