package io.dinixweb.SpringbootgraphQL.resources;

import io.dinixweb.SpringbootgraphQL.model.Guardian;
import io.dinixweb.SpringbootgraphQL.model.Students;
import io.dinixweb.SpringbootgraphQL.repository.GuardianRepository;
import io.dinixweb.SpringbootgraphQL.repository.StudentRepository;
import io.dinixweb.SpringbootgraphQL.repository.SubjectRepository;
import io.dinixweb.SpringbootgraphQL.response.GlobalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
        students.stream().forEach(x->x.setGuardian(guardianRepository.findByStudentId(x.getStudentId())));
        return students;
    }

    @QueryMapping
    Optional<Students> studentById(@Argument Long id){
        Optional<Students> students =  studentRepository.findById(id);
        students.stream().forEach(e->e.setSubjects(subjectRepository.findByStudentId(e.getStudentId())));
        students.stream().forEach(x->x.setGuardian(guardianRepository.findByStudentId(x.getStudentId())));
        return students;
    }

    @MutationMapping
    Students addStudent(@Argument StudentInput student, @Argument GuardianInput guardian){
        Students s  = new Students(student.studentId(),student.firstName(), student.lastName(), student.grade());
        Guardian guardian1 = new Guardian(guardian.guardianId(), guardian.firstName(), guardian.lastName(), guardian.email(), guardian.studentId());
        guardianRepository.save(guardian1);
        return studentRepository.save(s);

    }
    record StudentInput(long studentId,String firstName, String lastName, String grade ){
    }
    record GuardianInput(long guardianId, String firstName, String lastName, String email, long studentId  ){
    }

    @MutationMapping
    GlobalResponse deleteStudent (@Argument long studentId){
        Optional<Students> students =  studentRepository.findById(studentId);
       if(students.isEmpty()){
           return new GlobalResponse(false, "no user found", studentId);
       }
          studentRepository.deleteById(studentId);
        return new GlobalResponse(true, "no errors", studentId);
    }

}
