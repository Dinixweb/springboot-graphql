package io.dinixweb.SpringbootgraphQL.resources;

import io.dinixweb.SpringbootgraphQL.model.Guardian;
import io.dinixweb.SpringbootgraphQL.model.Students;
import io.dinixweb.SpringbootgraphQL.repository.GuardianRepository;
import io.dinixweb.SpringbootgraphQL.repository.StudentRepository;
import io.dinixweb.SpringbootgraphQL.repository.SubjectRepository;
import io.dinixweb.SpringbootgraphQL.response.GlobalResponse;
import io.dinixweb.SpringbootgraphQL.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
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

    /**
     * This method will return list of all students alongside their subjects and guarantors in db
     * @return StudentList
     */
    @QueryMapping
    Iterable<Students> students(){
        List<Students> students =  studentRepository.findAll();
        students.stream().forEach(e->e.setSubjects(subjectRepository.findByStudentId(e.getStudentId())));
        students.stream().forEach(x->x.setGuardian(guardianRepository.findByStudentId(x.getStudentId())));
        return students;
    }

    /**
     * This method will return a single student with their details
     * @param id
     * @return
     */
    @QueryMapping
    Optional<Students> studentById(@Argument Long id){
        Optional<Students> students =  studentRepository.findById(id);
        students.stream().forEach(e->e.setSubjects(subjectRepository.findByStudentId(e.getStudentId())));
        students.stream().forEach(x->x.setGuardian(guardianRepository.findByStudentId(x.getStudentId())));
        return students;
    }

    /**
     * This is a mutation method. for adding new students and their guarantors
     * @param student
     * @param guardian
     * @return
     */
    @MutationMapping
    Students addStudent(@Argument StudentInput student, @Argument GuardianInput guardian){
        Students s  = new Students(student.studentId(),student.firstName(), student.lastName(), student.grade());
        Guardian guardian1 = new Guardian(guardian.guardianId(), guardian.firstName(), guardian.lastName(), guardian.email(), guardian.studentId());
        guardianRepository.save(guardian1);
        return studentRepository.save(s);

    }


    /**
     * Update method. this method will update a single student if they exist in the database
     * @param studentId
     * @param student
     * @return
     */
    @MutationMapping
    UpdateResponse updateStudent(@Argument long studentId, @Argument StudentInput student) {
        System.out.println(student);
        Optional<Students> students =  studentRepository.findById(studentId);
        if(students.isEmpty()){
           return new UpdateResponse(false, studentId, "update was not successful");
        }else {
            Students students1 = students.stream().filter(obj->Objects.equals(studentId, obj.getStudentId())).findAny().orElse(null);
            students1.setFirstName(student.firstName());
            students1.setLastName(student.lastName());
            students1.setGrade(student.grade());
            studentRepository.save(students1);
        }
        return new UpdateResponse(true, studentId, "student successfully updated" );

    }

    /**
     * This method will delete a student in the database if they exist
     * @param studentId
     * @return
     */
    @MutationMapping
    GlobalResponse deleteStudent (@Argument long studentId){
        Optional<Students> students =  studentRepository.findById(studentId);
       if(students.isEmpty()){
           return new GlobalResponse(false, "no user found", studentId);
       }
          studentRepository.deleteById(studentId);
        return new GlobalResponse(true, "no errors", studentId);
    }


    //Record Input
    record StudentInput(long studentId,String firstName, String lastName, String grade ){
    }

    record UpdateStudentInput(String firstName, String lastName, String grade ){
    }



    record GuardianInput(long guardianId, String firstName, String lastName, String email, long studentId  ){
    }

}
