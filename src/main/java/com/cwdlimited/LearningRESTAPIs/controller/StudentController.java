package com.cwdlimited.LearningRESTAPIs.controller;

import com.cwdlimited.LearningRESTAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent() {
        return new StudentDto(18L,"Virat","virat.kohli@gmail.com");
    }
}
