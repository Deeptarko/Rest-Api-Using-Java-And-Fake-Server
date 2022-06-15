package com.deep.springbootpractice.controllers;

import com.deep.springbootpractice.entities.Student;
import com.deep.springbootpractice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String homePage(){
        return "Hello";
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student s){
        return studentService.saveStudent(s);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable("studentId") Long studentId,@RequestBody  Student updatedStudent){
        return studentService.updateStudent(studentId,updatedStudent);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        return studentService.deleteStudent(studentId);
    }
}
