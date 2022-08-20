package io.dinixweb.SpringbootgraphQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subjects {

    @Id
    private long subjectId;
    private String subjectName;
    private String subjectTeacher;
    private long studentId;
    public Subjects(long subjectId, String subjectName, String subjectTeacher, long studentId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectTeacher = subjectTeacher;
        this.studentId = studentId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    Students students;

}
