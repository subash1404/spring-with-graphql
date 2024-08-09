package com.example.response;

import com.example.entity.Student;
import com.example.entity.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentResponse {
    // For internal use. Dont put it in schema
    private Student student;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
    private List<SubjectResponse> learningSubjects;

    public StudentResponse(Student student) {
        this.student = student;
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.city = student.getAddress().getCity();
        this.street = student.getAddress().getStreet();

//        if(student.getLearningSubjects() !=null){
//            learningSubjects = new ArrayList<>();
//            for (Subject subject : student.getLearningSubjects()) {
//                this.learningSubjects.add(new SubjectResponse(subject));
//            }
//        }
    }
}
