package io.dinixweb.SpringbootgraphQL.repository;

import io.dinixweb.SpringbootgraphQL.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Long> {
}
