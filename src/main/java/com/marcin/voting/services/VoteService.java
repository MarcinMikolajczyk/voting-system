package com.marcin.voting.services;

import com.marcin.voting.exeptions.InvalidOperationException;
import com.marcin.voting.models.Vote;
import com.marcin.voting.models.Voter;
import com.marcin.voting.models.mappers.VoteMapper;
import com.marcin.voting.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final VoterService voterService;
    private ProjectService projectService;

    @Autowired
    public VoteService(VoteRepository voteRepository, VoterService voterService, ProjectService projectService) {
        this.voteRepository = voteRepository;
        this.voterService = voterService;
        this.projectService = projectService;
    }

    public Vote save(Vote vote){
        if(voteRepository.existsByProject(vote.getProject()) &&
            voteRepository.existsByVoter(vote.getVoter())){
            throw new InvalidOperationException(String.format("Voter with id %d already voted on project with id %d",
                    vote.getVoter().getId(), vote.getProject().getId()));
        }
        return voteRepository.save(vote);
    }

    public Vote save(VoteMapper voteMapper){
        Vote vote = new Vote();
        vote.setVoteFor(voteMapper.isVote());
        vote.setVoter(voterService.getOneByVouteId(voteMapper.getVoter_id()));
        vote.setProject(projectService.getOne(voteMapper.getProject_id()));
        return save(vote);
    }
}
