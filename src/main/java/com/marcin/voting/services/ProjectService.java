package com.marcin.voting.services;

import com.marcin.voting.exeptions.InvalidOperationException;
import com.marcin.voting.exeptions.JPAObjectNotFoundException;
import com.marcin.voting.models.Project;
import com.marcin.voting.models.Vote;
import com.marcin.voting.models.mappers.ProjectDetails;
import com.marcin.voting.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public Project getOneWithVotes(Long id){
        return projectRepository.findProjectWithAllVotes(id).orElseThrow(
                () -> new JPAObjectNotFoundException("id", String.valueOf(id)));
    }

    public Project getOne(Long id){
        return projectRepository.findById(id).orElseThrow(
                () -> new JPAObjectNotFoundException("id", String.valueOf(id)));
    }

    public Project save(Project project){
        if(projectRepository.existsByName(project.getName())) {
            throw new InvalidOperationException(String.format("Project with name %s already exist", project.getName()));
        }
        return projectRepository.save(project);
    }

    public Project update(Long id, boolean votable){
        return projectRepository.findById(id).map(p -> {
            p.setVotable(votable);
            return projectRepository.save(p);
        }).orElseThrow(() -> new JPAObjectNotFoundException("id", String.valueOf(id)));
    }

    public List<Project> getAll(String order){
        if(order.equals("Asc")){
            return projectRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        }else if(order.equals("Desc")){
            return projectRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        }else{
            throw new InvalidOperationException(String.format("There is no order %s, (only Asc and Desc)", order));
        }
    }

    public ProjectDetails getProjectDetails(Long id){
        return projectRepository.findProjectWithAllVotes(id).map(project -> {
            ProjectDetails details = new ProjectDetails();
            details.setName(project.getName());
            details.setDescription(project.getDescription());
            details.setCan_vote(project.isVotable());
            details.setVotes_for(project.getVotes().stream()
                    .filter(Vote::isVoteFor).count());
            details.setVotes_against(project.getVotes()
                    .stream()
                    .filter(vote -> !vote.isVoteFor()).count());
            return details;
        }).orElseThrow(() -> new JPAObjectNotFoundException("id", String.valueOf(id)));
    }
}
