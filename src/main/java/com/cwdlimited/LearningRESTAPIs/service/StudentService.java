package com.cwdlimited.LearningRESTAPIs.service;
import com.cwdlimited.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.cwdlimited.LearningRESTAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateAStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialAStudent(Long id, Map<String, Object> updates);
}
