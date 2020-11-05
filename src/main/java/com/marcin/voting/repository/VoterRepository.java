package com.marcin.voting.repository;

import com.marcin.voting.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {
    boolean existsByFirstName(String firstName);
    boolean existsByLastName(String lastNmae);
    boolean existsByVoteId(String id);
    Optional<Voter> findVoterByVoteId(String id);
}
