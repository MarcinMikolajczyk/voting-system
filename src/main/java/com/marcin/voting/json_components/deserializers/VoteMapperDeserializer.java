package com.marcin.voting.json_components.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.marcin.voting.exeptions.InvalidOperationException;
import com.marcin.voting.models.mappers.VoteMapper;

import java.io.IOException;

public class VoteMapperDeserializer extends StdDeserializer<VoteMapper> {

    public VoteMapperDeserializer() { this(null); }


    public VoteMapperDeserializer(Class<VoteMapper> vc) { super(vc); }

    @Override
    public VoteMapper deserialize(JsonParser p, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = p.getCodec().readTree(p);

        VoteMapper vote = new VoteMapper();

        JsonNode voterId = node.get("voter_id");
        if(voterId == null){
            throw new InvalidOperationException("voter_id is required");
        }
        vote.setVoter_id(voterId.asText());

        JsonNode projectId = node.get("project_id");
        if(projectId == null){
            throw new InvalidOperationException("project_id is required");
        }
        vote.setProject_id(projectId.asLong());

        JsonNode voteFor = node.get("vote");
        if(voterId == null){
            throw new InvalidOperationException("vote is required");
        }
        vote.setVote(voteFor.asBoolean());

        return vote;
    }



}
