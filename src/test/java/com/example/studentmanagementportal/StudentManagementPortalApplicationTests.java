package com.example.studentmanagementportal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentManagementPortalApplicationTests {

	@Autowired
	StudentService studentService;

	@BeforeEach
	public void setup(){

		studentService.addStudent(new Student(1,"dummy1",23,"CSE"));
		studentService.addStudent(new Student(2,"dummy2",25,"CSE"));
		studentService.addStudent(new Student(3,"dummy3",30,"IT"));
	}

//	@Test
//	public void addStudentTest(){
//
//		studentService.addStudent(new Student(1,"dummy",23,"CSE"));
//		Student originalOutput = studentService.getStudent(1);
//
//		Student expectedOutput = new Student(1,"dummy",23,"CSE");
//		Assertions.assertEquals(expectedOutput.getAdmnNo(),originalOutput.getAdmnNo());
//		Assertions.assertEquals(expectedOutput.getAge(),originalOutput.getAge());
//		Assertions.assertEquals(expectedOutput.getName(),originalOutput.getName());
//		Assertions.assertEquals(expectedOutput.getCourse(),originalOutput.getCourse());
//	}

	@Test
	public void testGetStudent(){

		Student expectedOutput = new Student(2,"dummy2",25,"CSE");
		Student originalOutput = studentService.getStudent(2);
		Assertions.assertEquals(expectedOutput.getAdmnNo(),originalOutput.getAdmnNo());
		Assertions.assertEquals(expectedOutput.getAge(),originalOutput.getAge());
		Assertions.assertEquals(expectedOutput.getName(),originalOutput.getName());
		Assertions.assertEquals(expectedOutput.getCourse(),originalOutput.getCourse());
	}



}
