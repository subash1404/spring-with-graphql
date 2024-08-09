package com.example.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.entity.Student;
import com.example.request.CreateStudentRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class Mutation implements GraphQLMutationResolver {
    private final StudentService studentService;

    public Mutation(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        return new StudentResponse(studentService.createStudent(createStudentRequest));
    }
}
