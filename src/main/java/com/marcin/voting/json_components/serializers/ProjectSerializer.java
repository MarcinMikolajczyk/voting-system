package com.marcin.voting.json_components.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.marcin.voting.models.Project;

import java.io.IOException;

public class ProjectSerializer extends StdSerializer<Project> {

    public ProjectSerializer() {
        this(null);
    }

    public ProjectSerializer(Class<Project> p) {
        super(p);
    }

    @Override
    public void serialize(Project project, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("id", String.valueOf(project.getId()));
        jsonGenerator.writeStringField("name", project.getName());
        jsonGenerator.writeStringField("description", project.getDescription());

        jsonGenerator.writeEndObject();
    }
}
