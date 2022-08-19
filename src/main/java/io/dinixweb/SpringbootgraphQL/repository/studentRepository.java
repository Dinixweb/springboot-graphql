package io.dinixweb.SpringbootgraphQL.repository;

import io.dinixweb.SpringbootgraphQL.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Students, Long> {
}
