package com.example.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.entity.Subject;
import com.example.enums.SubjectFilter;
import com.example.response.StudentResponse;
import com.example.response.SubjectResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
// No need to call the methods explicitly
// All the methods in the resolver should be public
// Use resolver to improve the performance of the app
// Implement methods that handle business logic or methods that does some processing
public class StudentResposneResolver implements GraphQLResolver<StudentResponse> {
//    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse, SubjectFilter subjectFilter){
//        List<SubjectResponse> learningSubjects = new ArrayList<>();
//        if(studentResponse.getStudent().getLearningSubjects() !=null){
//            for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
//                if(subjectFilter.name().equalsIgnoreCase("ALL"))
//                    learningSubjects.add(new SubjectResponse(subject));
//                else if(subjectFilter.name().equalsIgnoreCase(subject.getSubjectName()))
//                    learningSubjects.add(new SubjectResponse(subject));
//            }
//        }
//        return learningSubjects;
//    }

    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse, List<SubjectFilter> subjectFilter){
        List<SubjectResponse> learningSubjects = new ArrayList<>();
        SubjectFilter[] allFilters = SubjectFilter.values();
        if(studentResponse.getStudent().getLearningSubjects() !=null){
            for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
                if(subjectFilter.contains(SubjectFilter.valueOf("All")))
                    learningSubjects.add(new SubjectResponse(subject));
                else {
                    for(SubjectFilter filter : allFilters){
                        if(subjectFilter.contains(filter) && subject.getSubjectName().equalsIgnoreCase(filter.name())){
                            learningSubjects.add(new SubjectResponse(subject));
                        }
                    }
                }
            }
        }
        return learningSubjects;
    }

    public String getFullName(StudentResponse studentResponse){
        return studentResponse.getFirstName() + " " + studentResponse.getLastName();
    }
}
