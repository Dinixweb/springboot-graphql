package io.dinixweb.SpringbootgraphQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subjects {

    @Id
    private long subjectId;
    private String subjectName;
    private String subjectTeacher;

    public Subjects(int i, String maths, String mr_joe) {
    }

    @ManyToOne
    @JoinColumn(name = "students_student_id")
    Students students;

}
