package com.example.service;

import com.example.entity.Address;
import com.example.entity.Student;
import com.example.entity.Subject;
import com.example.repository.AddressRepository;
import com.example.repository.StudentRepository;
import com.example.repository.SubjectRepository;
import com.example.request.CreateStudentRequest;
import com.example.request.CreateSubjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student(createStudentRequest);
        Address address = new Address();

        address.setStreet(createStudentRequest.getStreet());
        address.setCity(createStudentRequest.getCity());
        addressRepository.save(address);

        student.setAddress(address);
        studentRepository.save(student);

        List<Subject> subjectList = new ArrayList<>();

        if(createStudentRequest.getLearningSubjects() != null){
            for(CreateSubjectRequest createSubjectRequest : createStudentRequest.getLearningSubjects()) {
                Subject subject = new Subject();
                subject.setSubjectName(createSubjectRequest.getSubjectName());
                subject.setMarksObtained(createSubjectRequest.getMarksObtained());
                subject.setStudent(student);
                subjectList.add(subject);
            }
            subjectRepository.saveAll(subjectList);
        }
        student.setLearningSubjects(subjectList);
        return student;
    }
}
