package com.marcin.voting.json_components.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.marcin.voting.models.Voter;

import java.io.IOException;

public class VoterSerializer extends StdSerializer<Voter> {

    public VoterSerializer() {
        this(null);
    }

    public VoterSerializer(Class<Voter> p) {
        super(p);
    }

    @Override
    public void serialize(Voter voter, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("firstName", voter.getFirstName());
        jsonGenerator.writeStringField("lastName", voter.getLastName());
        jsonGenerator.writeStringField("voter_id", voter.getVoteId());


        jsonGenerator.writeEndObject();
    }
}
