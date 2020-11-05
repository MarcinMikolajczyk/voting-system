package com.marcin.voting.repository;

import com.marcin.voting.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    boolean existsByVoter(Long aLong);
    boolean existsByProject(Long aLong);
}
