package com.example.studentmanagementportal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@Repository
public class StudentRepository {

    Map<Integer,Student> studentsDb = new HashMap<>(); // db - key - admnNo

    public Student getStudent(int admnNo){
        return studentsDb.get(admnNo);
    }

    public String addStudent(Student student){

        if(studentsDb.containsKey(student.getAdmnNo())){
            return "Student already present";
        }

        studentsDb.put(student.getAdmnNo(),student);
        return "Student added successfully";
    }

    public Student getStudentByPathVariable(int admnNo) {

        return studentsDb.get(admnNo);
    }
}
