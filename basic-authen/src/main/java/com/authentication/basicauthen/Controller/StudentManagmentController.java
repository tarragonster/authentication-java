package com.authentication.basicauthen.Controller;

import com.authentication.basicauthen.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/management")
public class StudentManagmentController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Jame Bond"),
            new Student(2, "Maria Jones"),
            new Student(2, "Anna Smith")
    );

    @GetMapping
    public List<Student> getAllStudents(){
        return STUDENTS;
    }

    @PostMapping
    public String registerNewStudent(@RequestBody Student student){
        return student.getStudentName();
    }

    @DeleteMapping
    public Integer deleteStudent(@RequestParam("studentId") Integer studentId){
        return studentId;
    }
}
