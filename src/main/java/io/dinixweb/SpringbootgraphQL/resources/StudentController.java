package io.dinixweb.SpringbootgraphQL.resources;

import io.dinixweb.SpringbootgraphQL.model.Students;
import io.dinixweb.SpringbootgraphQL.repository.GuardianRepository;
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

    @Autowired
    private final SubjectRepository subjectRepository;

    @Autowired
    private final GuardianRepository guardianRepository;

    public StudentController(StudentRepository studentRepository, SubjectRepository subjectRepository, GuardianRepository guardianRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.guardianRepository = guardianRepository;
    }


    @QueryMapping
    Iterable<Students> students(){
        List<Students> students =  studentRepository.findAll();
        students.stream().forEach(e->e.setSubjects(subjectRepository.findByStudentId(e.getStudentId())));
        students.stream().forEach(x->x.setGuardian(((guardianRepository.findByStudentId(x.getStudentId())))));
        return students;
    }
}
