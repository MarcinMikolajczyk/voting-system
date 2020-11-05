package com.marcin.voting.router.handlers;

import com.marcin.voting.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class ProjectHandler {

    private final ProjectService projectService;

    @Autowired
    public ProjectHandler(ProjectService projectService) {
        this.projectService = projectService;
    }

    public ServerResponse handleGetAll(ServerRequest request){
        return ServerResponse.ok().body(projectService.getAll(Sort.by(Sort.Direction.ASC, "name")));
    }

}
