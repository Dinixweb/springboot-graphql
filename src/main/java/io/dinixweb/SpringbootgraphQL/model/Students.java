package io.dinixweb.SpringbootgraphQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Students {

    @Id
    private long studentId;
    private String firstName;
    private String lastName;
    private String grade;

    public Students(long studentId, String firstName, String lastName, String grade) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    @OneToMany(mappedBy = "students")
    private List<Subjects> subjects;

    @OneToOne
    private Guardian guardian;

}
