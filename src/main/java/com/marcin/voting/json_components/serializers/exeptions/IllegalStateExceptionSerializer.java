package com.marcin.voting.json_components.serializers.exeptions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class IllegalStateExceptionSerializer extends StdSerializer<IllegalStateException> {

    public IllegalStateExceptionSerializer() {
        this(null);
    }

    public IllegalStateExceptionSerializer(Class<IllegalStateException> e) {
        super(e);
    }

    @Override
    public void serialize(IllegalStateException e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("status", 406);
        jsonGenerator.writeStringField("message", e.getMessage());

        jsonGenerator.writeEndObject();
    }


}
