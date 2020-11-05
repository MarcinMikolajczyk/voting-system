package com.marcin.voting.repository;

import com.marcin.voting.models.Project;
import com.marcin.voting.models.Vote;
import com.marcin.voting.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    boolean existsByVoter(Voter aLong);
    boolean existsByProject(Project aLong);
}
