package com.marcin.voting.repository;

import com.marcin.voting.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    boolean existsByName(String name);

    @Query(value = "select p from Project p where p.id = :id")
    Optional<Project> findProjectWithAllVotes(@Param("id") Long id);
}
