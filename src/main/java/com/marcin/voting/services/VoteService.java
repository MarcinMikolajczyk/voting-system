package com.marcin.voting.services;

import com.marcin.voting.models.Vote;
import com.marcin.voting.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote save(Vote vote){
        if(voteRepository.existsByProject(vote.getProject().getId()) &&
            voteRepository.existsByVoter((vote.getVoter().getId()))){
            throw new IllegalStateException(String.format("Voter with id %d already voted on project with id %d",
                    vote.getVoter().getId(), vote.getProject().getId()));
        }
        return voteRepository.save(vote);
    }
}
