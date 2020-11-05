package com.marcin.voting.controllers;

import com.marcin.voting.models.Project;
import com.marcin.voting.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAll(@RequestParam(defaultValue = "Asc") String order){
        return projectService.getAll(order);
    }
}
