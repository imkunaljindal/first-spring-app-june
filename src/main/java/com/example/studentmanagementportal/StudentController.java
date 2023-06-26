package com.example.studentmanagementportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController{

    public static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @GetMapping("/get_info")
    public ResponseEntity getStudent(@RequestParam("id") int admnNo){
        Student s = studentService.getStudent(admnNo);
        if(s==null){
            return new ResponseEntity("Student not found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(s,HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        logger.warn(String.valueOf(student));
        logger.info("This is a INFO log");
        logger.warn("This is a WARN log");
        logger.error("This is a ERROR log");
        logger.trace("This is a TRACE log");
        String s = studentService.addStudent(student);
        return new ResponseEntity(s, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}/{message}")
    public String getStudentByPathVariable(@PathVariable("id") int admnNo, @PathVariable("message") String message){
        return studentService.getStudentByPathVariable(admnNo, message);
    }

    // Delete a student by admnNo
//    @DeleteMapping("/delete")
//    public String deleteStudent(@RequestParam("id") int admnNo){
//        studentsDb.remove(admnNo);
//        return "Student deleted successfully";
//    }
//
//    // update the course of a student based admnNo
//    @PutMapping("/update_course")
//    public Student updateCourse(@RequestParam("id") int admnNo,@RequestParam("course") String newCourse){
//        if(!studentsDb.containsKey(admnNo)){
//            throw new RuntimeException("Student doesn't exist");
//        }
//        Student student = studentsDb.get(admnNo);
//        student.setCourse(newCourse);
//        return student;
//    }
//
//    // total number of students whose age is greater than 25
//    @GetMapping("/get_total_students")
//    public int getTotalStudent(){
//
//        int total = 0;
//        for(int admnNo: studentsDb.keySet()){
//            if(studentsDb.get(admnNo).getAge()>25){
//                total++;
//            }
//        }
//        return total;
//    }
}