package com.marcin.voting.services;

import com.marcin.voting.models.Project;
import com.marcin.voting.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }


    public List<Project> getAll(Sort sort){
        return projectRepository.findAll(sort);
    }

    public Project getOne(Long id){
        return projectRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Project with id %d is not exist", id)));
    }

    public Project save(Project project){
        if(projectRepository.existsByName(project.getName())) {
            throw new IllegalStateException(String.format("Project with name %s already exist", project.getName()));
        }
        return projectRepository.save(project);
    }

    public Project update(Project project, Long id, boolean votable){
        return projectRepository.findById(id).map(p -> {
            p.setVotable(votable);
            return projectRepository.save(p);
        }).orElseThrow(() -> new IllegalStateException(String.format("Project with id %d is not exist", id)));
    }

}
