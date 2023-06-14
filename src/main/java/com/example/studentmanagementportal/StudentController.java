package com.example.studentmanagementportal;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController{

    Map<Integer,Student> studentsDb = new HashMap<>(); // db - key - admnNo

    @GetMapping("/get_info")
    public Student getStudent(@RequestParam("id") int admnNo){
        return studentsDb.get(admnNo);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        studentsDb.put(student.getAdmnNo(),student);
        return "Studewnt added successfully";
    }

    @GetMapping("/get/{id}/{message}")
    public Student getStudentByPathVariable(@PathVariable("id") int admnNo){
        return studentsDb.get(admnNo);
    }

    // Delete a student by admnNo

    // update the course of a student based admnNo

    // total number of students whose age is greater than 25
}