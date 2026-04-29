package com.cwdlimited.LearningRESTAPIs.service;
import com.cwdlimited.LearningRESTAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
}

