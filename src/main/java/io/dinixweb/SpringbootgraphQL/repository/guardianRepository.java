package io.dinixweb.SpringbootgraphQL.repository;

import io.dinixweb.SpringbootgraphQL.model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface guardianRepository extends JpaRepository<Guardian, Long> {
}
