package io.dinixweb.SpringbootgraphQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subjects {

    @Id
    private Long studentId;
    private String maths;
    private String english;
    private String physics;
    private String chemistry;
    private String statistics;
}
