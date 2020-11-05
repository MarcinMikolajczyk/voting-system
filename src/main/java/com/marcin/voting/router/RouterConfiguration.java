package com.marcin.voting.router;


import com.marcin.voting.router.handlers.ProjectHandler;
import com.marcin.voting.router.handlers.VoteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.*;

@Configuration
public class RouterConfiguration {

    private final VoteHandler voteHandler;
    private final ProjectHandler projectHandler;

    @Autowired
    public RouterConfiguration(VoteHandler voteHandler, ProjectHandler projectHandler) {
        this.voteHandler = voteHandler;
        this.projectHandler = projectHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction (VoteHandler voteHandler, ProjectHandler projectHandler){
        return route()
                .POST("/vote", voteHandler::handleSave)
                .GET("/projects", projectHandler::handleGetAll)
                .build();
    }

}
