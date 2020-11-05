package com.marcin.voting.models.mappers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.marcin.voting.json_components.deserializers.VoteMapperDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Data
@JsonDeserialize(using = VoteMapperDeserializer.class)
public class VoteMapper {
    private Long voter_id;
    private Long project_id;
    private boolean vote;
}
