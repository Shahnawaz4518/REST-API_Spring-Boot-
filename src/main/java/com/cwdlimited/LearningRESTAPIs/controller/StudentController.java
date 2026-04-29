package com.cwdlimited.LearningRESTAPIs.controller;

import com.cwdlimited.LearningRESTAPIs.dto.StudentDto;
import com.cwdlimited.LearningRESTAPIs.entity.Student;
import com.cwdlimited.repository.StudentRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;
    
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
    @GetMapping("/student/{id}")
    public StudentDto getStudentById(){
        return new StudentDto(18L,"Virat","virat.kohli@gmail.com");
    }
}
