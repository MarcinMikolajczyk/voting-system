package com.marcin.voting.models.mappers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter @Getter
public class ProjectDetails {

    private String name;
    private String description;
    private boolean can_vote;
    private Long votes_for;
    private Long votes_against;


    public ProjectDetails(String name,
                          String description,
                          boolean can_vote,
                          Long votes_for,
                          Long votes_against) {
        this.name = name;
        this.description = description;
        this.can_vote = can_vote;
        this.votes_for = votes_for;
        this.votes_against = votes_against;
    }
}
