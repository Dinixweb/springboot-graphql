package io.dinixweb.SpringbootgraphQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Students {

    @Id
    private long studentId;
    private String firstName;
    private String lastName;
    private String grade;

    @OneToMany
    private List<Subjects> subjectsList;

    @OneToOne
    private Guardian guardian;
}
