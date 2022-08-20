package io.dinixweb.SpringbootgraphQL.repository;

import io.dinixweb.SpringbootgraphQL.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subjects, Long> {
    List<Subjects> findByStudentId(long studentId);
}
