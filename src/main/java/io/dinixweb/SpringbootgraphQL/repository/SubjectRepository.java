package io.dinixweb.SpringbootgraphQL.repository;

import io.dinixweb.SpringbootgraphQL.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subjects, Long> {
}
