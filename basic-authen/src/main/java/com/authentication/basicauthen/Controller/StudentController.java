package com.authentication.basicauthen.Controller;

import com.authentication.basicauthen.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Jame Bond"),
            new Student(2, "Maria Jones"),
            new Student(2, "Anna Smith")
    );

    @GetMapping("/student")
    public Student getStudent(@RequestParam("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student" + studentId + "does not exists"));
    }
}
