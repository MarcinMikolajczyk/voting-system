package com.marcin.voting.router.handlers;

import com.marcin.voting.models.Vote;
import com.marcin.voting.models.mappers.VoteMapper;
import com.marcin.voting.services.ProjectService;
import com.marcin.voting.services.VoteService;
import com.marcin.voting.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.ServletException;
import java.io.IOException;

@Component
public class VoteHandler {

    private final VoteService voteService;
    private final VoterService voterService;
    private final ProjectService projectService;

    @Autowired
    public VoteHandler(VoteService voteService,
                       VoterService voterService,
                       ProjectService projectService) {
        this.voteService = voteService;
        this.voterService = voterService;
        this.projectService = projectService;
    }


    public ServerResponse handleSave(ServerRequest serverRequest) throws ServletException, IOException {
        VoteMapper voteMapper = serverRequest.body(VoteMapper.class);
        Vote vote = new Vote();
        vote.setVoteFor(voteMapper.isVote());
        vote.setVoter(voterService.getOne(voteMapper.getVoter_id()));
        vote.setProject(projectService.getOne(voteMapper.getProject_id()));
        voteService.save(vote);
        return ServerResponse.ok().body(null);
    }


}
