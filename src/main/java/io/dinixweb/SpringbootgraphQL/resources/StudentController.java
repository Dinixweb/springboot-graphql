package io.dinixweb.SpringbootgraphQL.resources;

import io.dinixweb.SpringbootgraphQL.model.Students;
import io.dinixweb.SpringbootgraphQL.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @QueryMapping
    Iterable<Students> students(){
        List<Students> students =  studentRepository.findAll();
        System.out.println("Printing Data: "+students);
        return students;
    }
}
