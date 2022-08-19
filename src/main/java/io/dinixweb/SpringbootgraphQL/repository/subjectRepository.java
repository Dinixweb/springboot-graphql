package io.dinixweb.SpringbootgraphQL.repository;

import io.dinixweb.SpringbootgraphQL.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface subjectRepository extends JpaRepository<Subjects, Long> {
}
