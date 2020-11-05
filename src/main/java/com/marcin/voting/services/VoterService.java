package com.marcin.voting.services;

import com.marcin.voting.models.Voter;
import com.marcin.voting.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterService {

    private final VoterRepository voterRepository;

    @Autowired
    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    public Voter save(Voter voter){
        if(voterRepository.existsByVoteId(voter.getVoteId())){
            throw new IllegalStateException(String.format("Voter with this VoteId already exist"));
        }
        return voterRepository.save(voter);
    }

    public Voter getOne(Long id){
        return voterRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Voter with id %d is not exist", id)));
    }
}
