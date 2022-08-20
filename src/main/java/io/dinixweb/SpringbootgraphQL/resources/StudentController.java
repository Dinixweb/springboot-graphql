package io.dinixweb.SpringbootgraphQL.resources;

import io.dinixweb.SpringbootgraphQL.model.Students;
import io.dinixweb.SpringbootgraphQL.model.Subjects;
import io.dinixweb.SpringbootgraphQL.repository.StudentRepository;
import io.dinixweb.SpringbootgraphQL.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public StudentController(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }


    @QueryMapping
    Iterable<Students> students(){
        List<Students> students =  studentRepository.findAll();
//        List<Subjects> subjectsList =  subjectRepository.findAll();
//        System.out.println(subjectsList);
//       students.forEach((e->e.setSubjectsList(subjectsList)));
        return students;
    }
}
