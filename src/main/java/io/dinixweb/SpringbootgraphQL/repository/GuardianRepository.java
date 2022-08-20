package io.dinixweb.SpringbootgraphQL.repository;

import io.dinixweb.SpringbootgraphQL.model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {
    Guardian findByStudentId(long studentId);
}
