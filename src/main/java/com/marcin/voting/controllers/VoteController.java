package com.marcin.voting.controllers;

import com.marcin.voting.models.mappers.VoteMapper;
import com.marcin.voting.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public void save(@RequestBody VoteMapper voteMapper){
        voteService.save(voteMapper);
    }

}
