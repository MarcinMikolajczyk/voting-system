package com.marcin.voting.services;

import com.marcin.voting.exeptions.InvalidOperationException;
import com.marcin.voting.exeptions.JPAObjectNotFoundException;
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

    public Project update(Project project, Long id, boolean votable){
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
            throw new InvalidOperationException(String.format("There is no order %s", order));
        }
    }
}
