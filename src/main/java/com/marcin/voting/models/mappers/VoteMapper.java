package com.marcin.voting.models.mappers;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Data
public class VoteMapper {
    private Long voter_id;
    private Long project_id;
    private boolean vote;
}
