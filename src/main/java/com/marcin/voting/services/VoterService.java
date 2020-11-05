package com.marcin.voting.services;

import com.marcin.voting.exeptions.InvalidOperationException;
import com.marcin.voting.exeptions.JPAObjectNotFoundException;
import com.marcin.voting.models.Voter;
import com.marcin.voting.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class VoterService {

    private final VoterRepository voterRepository;

    @Autowired
    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    public Voter save(Voter voter){
        if(voterRepository.existsByVoteId(voter.getVoteId())){
            throw new InvalidOperationException(String.format("Voter with this VoteId already exist"));
        }
        return voterRepository.save(voter);
    }

    public List<Voter> findAll(){
        return voterRepository.findAll();
    }

    public Voter getOne(Long id){
        return voterRepository.findById(id).orElseThrow(
                () -> new JPAObjectNotFoundException("id", String.valueOf(id)));
    }

}
