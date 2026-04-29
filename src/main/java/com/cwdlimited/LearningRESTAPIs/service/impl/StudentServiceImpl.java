
package com.cwdlimited.LearningRESTAPIs.service.impl;

import com.cwdlimited.LearningRESTAPIs.dto.StudentDto;
import com.cwdlimited.LearningRESTAPIs.entity.Student;
import com.cwdlimited.LearningRESTAPIs.repository.StudentRepository;
import com.cwdlimited.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students
        .stream()
        .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail())).collect(Collectors.toList());
    }
}
