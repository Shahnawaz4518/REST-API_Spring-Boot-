
package com.cwdlimited.LearningRESTAPIs.service.impl;

import com.cwdlimited.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.cwdlimited.LearningRESTAPIs.dto.StudentDto;
import com.cwdlimited.LearningRESTAPIs.entity.Student;
import com.cwdlimited.LearningRESTAPIs.repository.StudentRepository;
import com.cwdlimited.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students
        .stream()
        .map(student -> modelMapper.map(student, StudentDto.class))
        .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
       Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
       return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student Does Not Exists By ID: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateAStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
       Student student = studentRepository.findById(id)
       .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
       modelMapper.map(addStudentRequestDto, student);

       student = studentRepository.save(student);
       return modelMapper.map(student, StudentDto.class);
    }
}
