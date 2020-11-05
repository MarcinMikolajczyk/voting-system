package com.marcin.voting.configuration;

import com.marcin.voting.models.Project;
import com.marcin.voting.models.Voter;
import com.marcin.voting.services.ProjectService;
import com.marcin.voting.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {

    private final ProjectService projectService;
    private final VoterService voterService;

    @Autowired
    public DataConfiguration(ProjectService projectService, VoterService voterService) {
        this.projectService = projectService;
        this.voterService = voterService;

        // Voters
        this.voterService.save(new Voter("Adam", "Smith", "1234"));
        this.voterService.save(new Voter("Alice", "Walker", "2135"));
        this.voterService.save(new Voter("Emma", "Walker", "3234"));
        this.voterService.save(new Voter("Lily", "Williams", "4332"));
        this.voterService.save(new Voter("Kyle", "Roberts", "3428"));

        // Projects
        this.projectService.save(new Project("MyPhone", "Modern phone with long-acting battery."));
        this.projectService.save(new Project("I-Watch", "SmartWatch produced by apple."));
        this.projectService.save(new Project("Sony Xperia", "Smart phone produced by sony."));

    }

}
