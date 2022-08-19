package io.dinixweb.SpringbootgraphQL.controllers;

import io.dinixweb.SpringbootgraphQL.model.Students;
import io.dinixweb.SpringbootgraphQL.repository.studentRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

  private io.dinixweb.SpringbootgraphQL.repository.studentRepository studentRepository;

    @QueryMapping(value = "Students")
    Iterable<Students> getAllStudents(){
        return studentRepository.findAll();
    }
}
