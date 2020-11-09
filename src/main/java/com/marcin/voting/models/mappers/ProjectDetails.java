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

}
